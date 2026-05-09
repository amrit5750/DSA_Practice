package com.dsa.dailyDigest;

public class MakeMinSubarray {

    public static void main(String[] args) {

        int[] nums = { 3, 1, 4, 2 };
        int p = 6;

        System.out.println(minSubarray(nums, p));

    }

    public static int minSubarray(int[] nums, int p) {

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % p == 0) {
            return 0;
        }

        return 1;

    }

}
