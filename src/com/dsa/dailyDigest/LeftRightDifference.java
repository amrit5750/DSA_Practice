package com.dsa.dailyDigest;

import java.util.Arrays;

public class LeftRightDifference {

    public static void main(String[] args) {

        int[] nums = { 10, 4, 8, 3 };
        System.out.println(Arrays.toString(leftRightDifference(nums)));

    }

    public static int[] leftRightDifference(int[] nums) {

        int leftSum = 0;
        int totalSum = 0;

        for (int i : nums) {
            totalSum += i;

        }
        int[] ans = new int[nums.length];

        for (int i = 0; i < ans.length; i++) {
            totalSum -= nums[i];
            ans[i] = Math.abs(totalSum - leftSum);
            leftSum += nums[i];

        }

        return ans;

    }

}
