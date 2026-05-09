package com.dsa.arrays.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Two Sum Problem
 * 
 * Given an array of integers nums and an integer target,
 * return indices of the two numbers such that they add up to target.
 * 
 * You may assume that each input would have exactly one solution,
 * and you may not use the same element twice.
 */
public class TwoSum {

    /**
     * Approach 1: Using HashMap (Optimal Solution)
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */
    public static int[] twoSumHashMap(int[] nums, int target) {
        // HashMap to store value and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            // Add current element to map
            map.put(nums[i], i);
        }

        // No solution found
        return new int[] { -1, -1 };
    }

    /**
     * Approach 2: Brute Force (For comparison)
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }

        // No solution found
        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        // Test Case 1
        int[] nums1 = { 2, 7, 11, 15 };
        int target1 = 9;
        System.out.println("Test Case 1:");
        System.out.println("Input: nums = " + Arrays.toString(nums1) + ", target = " + target1);
        System.out.println("Output (HashMap): " + Arrays.toString(twoSumHashMap(nums1, target1)));
        System.out.println("Output (Brute Force): " + Arrays.toString(twoSumBruteForce(nums1, target1)));
        System.out.println();

        // Test Case 2
        int[] nums2 = { 3, 2, 4 };
        int target2 = 6;
        System.out.println("Test Case 2:");
        System.out.println("Input: nums = " + Arrays.toString(nums2) + ", target = " + target2);
        System.out.println("Output (HashMap): " + Arrays.toString(twoSumHashMap(nums2, target2)));
        System.out.println("Output (Brute Force): " + Arrays.toString(twoSumBruteForce(nums2, target2)));
        System.out.println();

        // Test Case 3
        int[] nums3 = { 3, 3 };
        int target3 = 6;
        System.out.println("Test Case 3:");
        System.out.println("Input: nums = " + Arrays.toString(nums3) + ", target = " + target3);
        System.out.println("Output (HashMap): " + Arrays.toString(twoSumHashMap(nums3, target3)));
        System.out.println("Output (Brute Force): " + Arrays.toString(twoSumBruteForce(nums3, target3)));
        System.out.println();

        // Test Case 4
        int[] nums4 = { 1, 5, 3, 7, 9, 2 };
        int target4 = 10;
        System.out.println("Test Case 4:");
        System.out.println("Input: nums = " + Arrays.toString(nums4) + ", target = " + target4);
        System.out.println("Output (HashMap): " + Arrays.toString(twoSumHashMap(nums4, target4)));
        System.out.println("Output (Brute Force): " + Arrays.toString(twoSumBruteForce(nums4, target4)));
    }
}
