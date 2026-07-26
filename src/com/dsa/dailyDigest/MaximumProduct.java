package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaximumProduct {

    public static int maximumProduct(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;

        int lastProduct = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int firstProduct = nums[0] * nums[1] * nums[n - 1];
        return Math.max(lastProduct, firstProduct);

    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(maximumProduct(nums));

    }

}
