package com.dsa.Heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Pair {
    int value1;
    int value2;
    int index;

    Pair(int value1, int value2, int index) {
        this.value1 = value1;
        this.value2 = value2;
        this.index = index;
    }
}

public class ChooseKelementsWithMaxSum {

    public static void main(String[] args) {

        int[] nums1 = { 4, 2, 1, 5, 3 };
        int[] nums2 = { 10, 20, 30, 40, 50 };
        int k = 2;

        System.out.println(Arrays.toString(findMaxSum(nums1, nums2, k)));
    }

    public static long[] findMaxSumOptimal(int[] nums1, int[] nums2, int k) {

        long[] ans = new long[nums1.length];
        Pair[] pairs = new Pair[nums1.length];

        for (int i = 0; i < nums1.length; i++) {
            pairs[i] = new Pair(nums1[i], nums2[i], i);
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(a.value1, b.value1));

        PriorityQueue<Integer> minHQueue = new PriorityQueue<>();

        for (Pair pair : pairs) {
            long sum = 0;
            for (Integer val : minHQueue) {
                sum += val;
            }
            ans[pair.index] = sum;

            minHQueue.add(pair.value2);
            if (minHQueue.size() > k) {
                minHQueue.poll();
            }

        }

        return ans;
    }

    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums2.length; i++) {
            map.put(i, nums2[i]);
        }
        long[] ans = new long[nums1.length];
        for (int i = 0; i < ans.length; i++) {
            List<Integer> indexes = new ArrayList<>();
            for (int j = 0; j < ans.length; j++) {
                if (nums1[i] > nums1[j]) {
                    indexes.add(j);
                }
            }
            ans[i] = getMaxTwoElements(map, indexes, k);
        }
        return ans;
    }

    public static long getMaxTwoElements(Map<Integer, Integer> map, List<Integer> indexes, int k) {
        long ans = 0;
        PriorityQueue<Integer> maxHQueue = new PriorityQueue<>();
        for (int i = 0; i < indexes.size(); i++) {
            maxHQueue.add(map.get(indexes.get(i)));
            if (maxHQueue.size() > k) {
                maxHQueue.poll();
            }
        }
        while (!maxHQueue.isEmpty()) {
            ans += maxHQueue.poll();
        }
        return ans;
    }
}
