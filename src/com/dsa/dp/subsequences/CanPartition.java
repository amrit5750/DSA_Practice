package com.dsa.dp.subsequences;

import java.util.Arrays;

public class CanPartition {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 5 };
        System.out.println(canPartition(nums));

    }

    public static boolean canPartition(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][target + 1];
        return canPartitionHelper(nums, 0, target, dp);

    }

    public static boolean canPartitionHelper(int[] nums, int index, int target, Boolean[][] dp) {

        if (target == 0) {
            return true;
        }
        if (index >= nums.length || target < 0) {
            return false;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }

        boolean take = canPartitionHelper(nums, index + 1, target - nums[index], dp);
        boolean NoteTake = canPartitionHelper(nums, index + 1, target, dp);

        return dp[index][target] = take || NoteTake;

    }
}