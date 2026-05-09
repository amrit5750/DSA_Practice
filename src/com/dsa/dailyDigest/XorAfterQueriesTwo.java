package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XorAfterQueriesTwo {

    public static final int M = 1000000007;

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1 };
        int[][] queries = { { 0, 2, 1, 4 } };

        System.out.println(xorAfterQueries(nums, queries));

    }

    public static long power(long a, long b) {

        if (b == 0) {
            return 1;
        }
        long half = power(a, b / 2);
        long result = (half * half) % M;

        if (b % 2 == 1) {
            result = (result * a) % M;
        }
        return result;
    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int blockSize = (int) Math.ceil(Math.sqrt(n));

        // Map: k -> list of queries
        Map<Integer, List<int[]>> smallKMap = new HashMap<>();

        // Step 1: Process large K directly
        for (int[] query : queries) {
            int L = query[0];
            int R = query[1];
            int K = query[2];
            int V = query[3];

            if (K >= blockSize) {
                for (int i = L; i <= R; i += K) {
                    nums[i] = (int) ((1L * nums[i] * V) % M);
                }
            } else {
                smallKMap.computeIfAbsent(K, k -> new ArrayList<>()).add(query);
            }
        }

        // Step 2: Process small K using diff array
        for (Map.Entry<Integer, List<int[]>> entry : smallKMap.entrySet()) {
            int K = entry.getKey();
            List<int[]> allQueries = entry.getValue();

            long[] diff = new long[n];
            Arrays.fill(diff, 1);

            // Apply all queries of this K
            for (int[] query : allQueries) {
                int L = query[0];
                int R = query[1];
                int V = query[3];

                diff[L] = (diff[L] * V) % M;

                int steps = (R - L) / K;
                int next = L + (steps + 1) * K;

                if (next < n) {
                    diff[next] = (diff[next] * power(V, M - 2)) % M;
                }
            }

            // Propagation (jump by K)
            for (int i = 0; i < n; i++) {
                if (i - K >= 0) {
                    diff[i] = (diff[i] * diff[i - K]) % M;
                }
            }

            // Apply to nums
            for (int i = 0; i < n; i++) {
                nums[i] = (int) ((1L * nums[i] * diff[i]) % M);
            }
        }

        // Final XOR
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }

}
