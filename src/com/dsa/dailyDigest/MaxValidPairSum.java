package com.dsa.dailyDigest;

public class MaxValidPairSum {

    public static void main(String[] args) {
        int[] nums = { 1, 3, 5, 2, 8 };
        int k = 2;
        System.out.println(maxValidPairSum(nums, k));

    }

    public static int maxValidPairSum(int[] nums, int k) {

        int maxValue = Integer.MIN_VALUE;

        int[] suffixMAx = new int[nums.length + 1];

        for (int i = nums.length - 1; i >= 0; i--) {
            suffixMAx[i] = Math.max(nums[i], suffixMAx[i + 1]);
        }
        for (int i = 0; i + k < nums.length; i++) {
            maxValue = Math.max(maxValue, suffixMAx[i + k] + nums[i]);

        }
        return maxValue;

    }

}
