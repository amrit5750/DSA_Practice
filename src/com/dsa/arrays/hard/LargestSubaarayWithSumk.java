package com.dsa.arrays.hard;

import java.util.HashMap;
import java.util.Map;

public class LargestSubaarayWithSumk {

    public static void main(String[] args) {

        int[] nums = { 9, -3, 3, -1, 6, -5 };
        int target = 6;

        System.out.println(getlargestSubarrayBruteForce(nums, target));

    }

    public static int getlargestSubarrayBruteForce(int[] nums, int target) {

        int largest = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (sum == 0) {
                largest = i + 1;
            } else {
                if (map.containsKey(sum)) {
                    largest = Math.max(largest, i - map.get(sum));
                } else {
                    map.put(sum, i);
                }
            }

        }

        return largest;

    }

}