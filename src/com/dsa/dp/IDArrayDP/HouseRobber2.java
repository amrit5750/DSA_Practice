package com.dsa.dp.IDArrayDP;

public class HouseRobber2 {
    public static void main(String[] args) {

        int[] nums = { 2, 3, 2 };
        System.out.println(rob(nums));

    }

    public static int rob(int[] nums) {

        if (nums.length == 1)
            return nums[0];

        Integer[] dp = new Integer[nums.length];

        int takeFirstHouse = robHelper(nums, 0, dp, nums.length - 2);
        dp = new Integer[nums.length];
        int takeLastHouse = robHelper(nums, 1, dp, nums.length - 1);
        return Math.max(takeFirstHouse, takeLastHouse);

    }

    public static int robHelper(int[] nums, int index, Integer[] dp, int n) {

        if (index > n) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int steal = nums[index] + robHelper(nums, index + 2, dp, n);
        int skip = robHelper(nums, index + 1, dp, n);

        return dp[index] = Math.max(steal, skip);

    }

}
