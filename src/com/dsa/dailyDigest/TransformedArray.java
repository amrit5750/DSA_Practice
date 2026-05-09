package com.dsa.dailyDigest;

import java.util.Arrays;

public class TransformedArray {

    public static void main(String[] args) {

        int[] nums = { 3, -2, 1, 1 };

        System.out.println(Arrays.toString(getTransformedArray(nums)));

    }

    public static int[] getTransformedArray(int[] nums) {

        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int targetIndex = (nums[i] + i) % nums.length;

            if (targetIndex < 0) {
                targetIndex += nums.length;
            }

            result[i] = nums[targetIndex];

        }

        return result;

    }
}
