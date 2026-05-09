package com.dsa.arrays.hard;

public class MaximumProductSubarray {

    public static void main(String[] args) {

        int[] nums = { 2, 3, -2, 4 };

        System.out.println(maxProduct(nums));

    }

    public static int maxProduct(int[] nums) {

        int max = Integer.MIN_VALUE;

        int prefix = 1;
        int suffix = 1;

        for (int i = 0; i < nums.length; i++) {

            if (prefix == 0) {
                prefix = 1;
            }

            if (suffix == 0) {
                suffix = 1;
            }

            prefix = nums[i] * prefix;
            suffix = nums[nums.length - i - 1] * suffix;

            max = Math.max(max, Math.max(prefix, suffix));

        }

        return max;

    }

}
