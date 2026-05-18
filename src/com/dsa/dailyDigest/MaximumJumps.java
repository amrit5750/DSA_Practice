package com.dsa.dailyDigest;

public class MaximumJumps {
    public static void main(String[] args) {

        int[] nums = { 1, 3, 6, 4, 1, 2 };
        int target = 2;
        System.out.println(maximumJumps(nums, target));

    }

    public static int maximumJumps(int[] nums, int target) {
        Integer[] memo = new Integer[nums.length + 1];
        return maximumJumpsHelper(nums, target, 0, memo);

    }

    public static int maximumJumpsHelper(int[] nums, int target, int index, Integer[] memo) {

        if (index == nums.length - 1) {
            return memo[index] = 0;
        }

        int maxJumps = Integer.MIN_VALUE;

        if (memo[index] != null) {
            return memo[index];
        }

        for (int i = index + 1; i < nums.length; i++) {
            int difference = Math.abs(nums[i] - nums[index]);

            if (difference <= target) {
                int result = maximumJumpsHelper(nums, target, i, memo);
                if (result != -1) {
                    memo[index] = maxJumps = Math.max(maxJumps, result + 1);
                }

            }

        }
        return memo[index] = maxJumps == Integer.MIN_VALUE ? -1 : maxJumps;
    }

}
