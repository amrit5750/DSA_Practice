package com.dsa.dailyDigest;

import java.util.Arrays;

public class GcdSum {

    public static void main(String[] args) {
        int[] nums = { 3, 6, 2, 8 };
        System.out.println(gcdSum(nums));

    }

    public static long gcdSum(int[] nums) {

        int max = nums[0];

        int[] prefixGCD = new int[nums.length];
        for (int i = 0; i < prefixGCD.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGCD[i] = getGCD(nums[i], max);
        }

        Arrays.sort(prefixGCD);

        long ans = 0;

        int left = 0;
        int right = prefixGCD.length - 1;

        while (left < right) {
            ans += getGCD(prefixGCD[left], prefixGCD[right]);
            left++;
            right--;
        }

        return ans;

    }

    public static int getGCD(int a, int b) {
        if (a == 0) {
            return b;

        }
        return getGCD(b % a, a);
    }

}
