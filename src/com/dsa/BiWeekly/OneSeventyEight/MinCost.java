package com.dsa.BiWeekly.OneSeventyEight;

import java.util.HashMap;
import java.util.Map;

public class MinCost {

    public static void main(String[] args) {
        int[] nums1 = { 10, 20 };
        int[] nums2 = { 20, 10 };

        System.out.println(minCost(nums1, nums2));

    }

    public static int minCost(int[] nums1, int[] nums2) {

        int swaps = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums1) {
            map.put(i, map.getOrDefault(i, 0) + 1);

        }
        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) - 1);
        }
        for (int i : map.values()) {
            if (i % 2 != 0) {
                return -1;
            }
            swaps += Math.abs(i) / 2;
        }
        return swaps / 2;
    }

}
