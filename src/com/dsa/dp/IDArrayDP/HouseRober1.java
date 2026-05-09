package com.dsa.dp.IDArrayDP;

public class HouseRober1 {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 1 };

        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {
        Integer[] dp = new Integer[nums.length];

        return robHelper(nums, 0, dp);

    }

    public static int robHelper(int[] nums, int index, Integer[] dp) {

        if (index >= nums.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int steal = nums[index] + robHelper(nums, index + 2, dp);
        int skip = robHelper(nums, index + 1, dp);
        return dp[index] = Math.max(steal, skip);

    }

}
