package com.dsa.BiWeekly.OneSeventyEight;

import java.util.Arrays;

public class GCDSum {
    public static void main(String[] args) {

        int[] nums = { 3, 6, 2, 8 };

        System.out.println(gcdSum(nums));

    }

    public static long gcdSum(int[] nums) {

        long ans = 0;
        int max = Integer.MIN_VALUE;

        int[] prefixGcd = new int[nums.length];

        for (int i = 0; i < prefixGcd.length; i++) {
            max = Math.max(max, nums[i]);
            prefixGcd[i] = getGCD(max, nums[i]);
        }

        Arrays.sort(prefixGcd);
        int left = 0;
        int right = prefixGcd.length - 1;

        while (left < right) {
            ans += getGCD(prefixGcd[left], prefixGcd[right]);
            left++;
            right--;
        }
        return ans;
    }

    public static int getGCD(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;

    }

    public static int getGCDOptimal(int a, int b) {

        if (b == 0) {
            return Math.abs(a);
        }

        return getGCDOptimal(b, a % b);

    }

}
