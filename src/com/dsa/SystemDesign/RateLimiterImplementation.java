package com.dsa.SystemDesign;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

// Rate limit the user based on user id and their tier( free or premium)
// support 4 types and extensible
// thread safe andf efficient.
public class RateLimiterImplementation {

    static void checkConcurrency(RateLimiterService rateLimiterService) throws InterruptedException {
        User freeUser1 = new User("user1", UserTier.FREE);

        int threads = 20; // simulate 20 concurrent requests
        ExecutorService executor = Executors.newFixedThreadPool(threads);

        CyclicBarrier barrier = new CyclicBarrier(threads);
        CountDownLatch latch = new CountDownLatch(threads);

        for (int i = 1; i <= threads; i++) {
            final int reqNum = i;
            executor.submit(() -> {
                try {
                    // all threads wait here until barrier is full
                    barrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }

                boolean allowed = rateLimiterService.allowRequest(freeUser1);
                System.out.println(Thread.currentThread().getName() +
                        " | Request " + reqNum + " for FreeUser1: " + (allowed ? "ALLOWED" : "BLOCKED"));

                latch.countDown();
            });
        }

        latch.await(); // wait for all threads to finish
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        RateLimiterService rateLimiterService = new RateLimiterService();
        checkConcurrency(rateLimiterService);

    }

}

class RateLimiterService {
    private final Map<UserTier, RateLimiter> rateLimiters = new HashMap<>();

    public RateLimiterService() {
        // Configure per-tier limits + algorithms
        rateLimiters.put(
                UserTier.FREE,
                RateLimiterFactory.createRateLimiter(
                        RateLimitType.TOKEN_BUCKET,
                        new RateLimitConfig(10, 60) // 10 req/min
                ));

        rateLimiters.put(
                UserTier.PREMIUM,
                RateLimiterFactory.createRateLimiter(
                        RateLimitType.FIXED_WINDOW,
                        new RateLimitConfig(100, 60) // 100 req/min
                ));
    }

    public boolean allowRequest(User user) {
        RateLimiter limiter = rateLimiters.get(user.getUserTier());
        if (limiter == null) {
            throw new IllegalArgumentException("No limiter configured for tier: " + user.getUserTier());
        }
        return limiter.allowRequest(user.getUserId());
    }
}

class RateLimiterFactory {
    public static RateLimiter createRateLimiter(RateLimitType algo, RateLimitConfig config) {
        return switch (algo) {
            case TOKEN_BUCKET -> new TokenBucketRateLimiter(config);
            case FIXED_WINDOW -> new FixedWindowRateLimiter(config);
            case SLIDING_WINDOW_LOG -> new SlidingWindowLogRateLimiter(config);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algo);
        };
    }
}

class TokenBucketRateLimiter extends RateLimiter {

    private final Map<String, Integer> tokens = new ConcurrentHashMap<>();
    private final Map<String, Long> lastRefillTime = new HashMap<>();

    public TokenBucketRateLimiter(RateLimitConfig config) {
        super(config, RateLimitType.TOKEN_BUCKET);
    }

    // user1 and user2
    // user1 and user1

    @Override
    public boolean allowRequest(String userId) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long now = System.currentTimeMillis();

        tokens.compute(userId, (id, availableTokens) -> {
            int currentTokens = refillTokens(userId, now);

            if (currentTokens > 0) {
                allowed.set(true); // mark allowed BEFORE we decrement
                return currentTokens - 1; // consume 1 token
            } else {
                return currentTokens; // remain at 0
            }
        });

        return allowed.get();
    }

    private int refillTokens(String userId, long now) {
        double refillRate = (double) config.getWindowInseconds() / config.getMaxRequests();

        long lastRefill = lastRefillTime.getOrDefault(userId, now);
        long elapsedSeconds = (now - lastRefill) / 1000;
        int refillTokens = (int) (elapsedSeconds / refillRate);

        int currentTokens = tokens.getOrDefault(userId, config.getMaxRequests());
        currentTokens = Math.min(config.getMaxRequests(), currentTokens + refillTokens);
        if (refillTokens > 0)
            lastRefillTime.put(userId, now);

        return currentTokens;
    }

}

abstract class RateLimiter {
    protected final RateLimitConfig config;
    protected final RateLimitType type;

    abstract boolean allowRequest(String userID);

    public RateLimiter(RateLimitConfig config, RateLimitType type) {
        this.config = config;
        this.type = type;
    }
}

class SlidingWindowLogRateLimiter extends RateLimiter {

    private final Map<String, Queue<Long>> requestLog = new ConcurrentHashMap<>();

    public SlidingWindowLogRateLimiter(RateLimitConfig config) {
        super(config, RateLimitType.SLIDING_WINDOW_LOG);
    }

    @Override
    boolean allowRequest(String userID) {
        AtomicBoolean allowed = new AtomicBoolean(false);
        long now = System.currentTimeMillis() / 1000;

        requestLog.compute(userID, (id, log) -> {
            if (log == null)
                log = new ArrayDeque<>();

            while (!log.isEmpty() && (now - log.peek()) >= config.getWindowInseconds()) {
                log.poll();
            }

            if (log.size() < config.getMaxRequests()) {
                log.add(now); // record this request
                allowed.set(true); // mark allowed
            }

            return log;
        });

        return allowed.get();
    }

}

class FixedWindowRateLimiter extends RateLimiter {

    private final Map<String, Integer> requestCount = new ConcurrentHashMap<>();
    private final Map<String, Long> windowStart = new HashMap<>();

    public FixedWindowRateLimiter(RateLimitConfig config) {
        super(config, RateLimitType.FIXED_WINDOW);
    }

    @Override
    boolean allowRequest(String userID) {
        AtomicBoolean allowed = new AtomicBoolean();

        long currentReqWindow = System.currentTimeMillis() / 100 / config.getWindowInseconds();

        requestCount.compute(userID, (id, count) -> {
            long lastReqWindow = windowStart.getOrDefault(id, currentReqWindow);

            if (lastReqWindow != currentReqWindow) {
                // window expired -> reset counter and window of last req
                windowStart.put(id, currentReqWindow);
                allowed.set(true);
                return 1; // first request in new window
            }

            if (count == null)
                count = 0;

            if (count < config.getMaxRequests()) {
                allowed.set(true);
                return count + 1; // increment count
            }

            return count; // remain same

        });

        return allowed.get();

    }

}

enum RateLimitType {
    TOKEN_BUCKET,
    LEAKY_BUCKET,
    FIXED_WINDOW,
    SLIDING_WINDOW_LOG,
    SLIDING_WINDOW, COUNTER;
}

enum UserTier {
    FREE,
    PREMIUM;
}

class RateLimitConfig {
    private final int maxRequests;
    private final int windowInseconds;

    public int getMaxRequests() {
        return maxRequests;
    }

    public int getWindowInseconds() {
        return windowInseconds;
    }

    public RateLimitConfig(int maxRequests, int windowInseconds) {
        this.maxRequests = maxRequests;
        this.windowInseconds = windowInseconds;
    }

}

class User {
    private final String userId;
    private final UserTier userTier;

    public String getUserId() {
        return userId;
    }

    public UserTier getUserTier() {
        return userTier;
    }

    public User(String userId, UserTier userTier) {
        this.userId = userId;
        this.userTier = userTier;
    }

}
