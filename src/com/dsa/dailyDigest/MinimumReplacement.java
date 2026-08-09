package com.dsa.dailyDigest;

public class MinimumReplacement {

    public static void main(String[] args) {

        int[] nums = { 3, 9, 3 };
        System.out.println(minimumReplacement(nums));

    }

    public static long minimumReplacement(int[] nums) {

        long operations = 0;
        int n = nums.length;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i + 1] >= nums[i]) {
                continue;
            }
            int parts = nums[i] / nums[i + 1];
            if (nums[i] % nums[i + 1] != 0) {
                parts++;
            }
            operations += parts - 1;
            nums[i] = nums[i] / parts;

        }

        return operations;

    }

}
