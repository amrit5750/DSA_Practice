package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaxProductTwo {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 4, 5 };
        System.out.println(maxProduct(nums));
    }

    public static int maxProduct(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        return (nums[n - 1] - 1) * (nums[n - 2] - 1);

    }

}
