package com.dsa.dailyDigest;

import java.util.Arrays;

public class IsGood {

    public static void main(String[] args) {
        int[] nums = { 1 };
        System.out.println(isGood(nums));

    }

    public static boolean isGood(int[] nums) {
        Arrays.sort(nums);

        int n = nums[nums.length - 1];

        // Length must be n + 1
        if (nums.length != n + 1) {
            return false;
        }

        // Check 1 to n-1
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] != i + 1) {
                return false;
            }
        }

        // Last two elements must both be n
        return nums[n - 1] == n && nums[n] == n;

    }

}
