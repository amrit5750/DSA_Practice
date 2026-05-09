package com.dsa.dailyDigest;

import java.util.Arrays;

public class GetSumAbsoluteDifferences {

    public static void main(String[] args) {

        int[] nums = { 1, 4, 6, 8, 10 };
        System.out.println(Arrays.toString(getSumAbsoluteDifferences(nums)));

    }

    public static int[] getSumAbsoluteDifferences(int[] nums) {

        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            int ele = 0;
            for (int j = 0; j < result.length; j++) {
                ele += Math.abs(nums[i] - nums[j]);
            }
            result[i] = ele;

        }

        return result;

    }

    public static int[] getSumAbsoluteDifferencesOptimal(int[] nums) {

        int[] result = new int[nums.length];
        int[] prefixSum = new int[nums.length];

        prefixSum[0] = nums[0];
        for (int i = 1; i < prefixSum.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            int leftSum = prefixSum[i] - nums[i];
            int rightSum = prefixSum[nums.length - 1] - prefixSum[i];

            result[i] = (nums[i] * i) - leftSum + rightSum - (nums[i] * (nums.length - i - 1));
        }

        return result;

    }

}
