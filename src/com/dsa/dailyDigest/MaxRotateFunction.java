package com.dsa.dailyDigest;

public class MaxRotateFunction {

    public static void main(String[] args) {

        int[] nums = { 4, 3, 2, 6 };
        System.out.println(maxRotateFunction(nums));

    }

    public static int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int f0 = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            f0 += i * nums[i];
        }
        int result = f0;
        for (int i = 0; i < nums.length; i++) {
            int newF = f0 + sum - n * nums[n - 1 - i];
            result = Math.max(result, newF);
            f0 = newF;
        }
        return result;

    }

}
