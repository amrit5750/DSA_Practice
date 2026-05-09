package com.dsa.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DesignTwitter {

    public static void main(String[] args) {

    }

}

class Twitter {

    Map<Integer, List<int[]>> tweets;
    Map<Integer, Set<Integer>> following;
    int time;

    public Twitter() {
        tweets = new HashMap<>();
        following = new HashMap<>();
        time = 0;

    }

    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(new int[] { time++, tweetId });

    }

    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        if (tweets.containsKey(userId)) {
            for (int[] tweets : tweets.get(userId)) {
                queue.add(tweets);
                if (queue.size() > 10) {
                    queue.poll();
                }
            }
        }

        if (following.containsKey(userId)) {
            for (int followee : following.get(userId)) {
                if (tweets.containsKey(followee)) {
                    for (int[] tweets : tweets.get(followee)) {
                        queue.add(tweets);
                        if (queue.size() > 10) {
                            queue.poll();
                        }
                    }
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int[] tweet = queue.poll();
            res.add(tweet[1]);
        }
        Collections.reverse(res);
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!following.containsKey(followerId)) {
            following.put(followerId, new HashSet<>());
        }
        following.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (following.containsKey(followerId)) {
            following.get(followerId).remove(followeeId);
        }
    }
}
