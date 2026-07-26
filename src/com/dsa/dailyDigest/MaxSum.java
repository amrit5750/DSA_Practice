package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaxSum {

    public static void main(String[] args) {
        int[] nums = { 3, 7, 5, 2 };
        int k = 2;
        int mul = 4;

        System.out.println(maxSum(nums, k, mul));

    }

    public static long maxSum(int[] nums, int k, int mul) {

        long sum = 0;
        Arrays.sort(nums);

        for (int i = nums.length - 1; i >= nums.length - k; i--) {

            if (mul > 0) {
                sum += (long) nums[i] * mul;
                mul--;
            } else {
                sum += nums[i];
            }

        }

        return sum;

    }

}
