package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongDistance {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 1, 1, 2 };
        System.out.println(Arrays.toString(distance(nums)));

    }

    public static long[] distanceOptimal(int[] nums) {

        Map<Integer, Long> indexSum = new HashMap<>();
        Map<Integer, Long> indexCount = new HashMap<>();

        long[] arr = new long[nums.length];

        for (int i = 0; i < nums.length; i++) {

            long sum = indexSum.getOrDefault(nums[i], 0L);
            long frequency = indexCount.getOrDefault(nums[i], 0L);
            arr[i] += frequency * i - sum;
            indexSum.put(nums[i], sum + i);
            indexCount.put(nums[i], frequency + 1);

        }

        indexSum.clear();
        indexCount.clear();

        for (int i = nums.length - 1; i >= 0; i--) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += sum - freq * i;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        return arr;

    }

    public static long[] distance(int[] nums) {

        int n = nums.length;
        long[] ans = new long[n];
        Map<Integer, List<Integer>> map = new HashMap<>();

        // Step 1: group indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Step 2: process each group
        for (List<Integer> indices : map.values()) {
            int size = indices.size();
            long[] prefix = new long[size];

            // build prefix sum
            prefix[0] = indices.get(0);
            for (int i = 1; i < size; i++) {
                prefix[i] = prefix[i - 1] + indices.get(i);
            }

            for (int j = 0; j < size; j++) {
                int idx = indices.get(j);

                long left = (long) idx * j - (j > 0 ? prefix[j - 1] : 0);
                long right = (prefix[size - 1] - prefix[j]) - (long) idx * (size - j - 1);

                ans[idx] = left + right;
            }
        }

        return ans;
    }

}
