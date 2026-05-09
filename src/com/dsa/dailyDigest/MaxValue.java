package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaxValue {

    public static void main(String[] args) {

        int[] nums = { 2, 1, 3 };
        System.out.println(Arrays.toString(maxValue(nums)));

    }

    public static int[] maxValue(int[] nums) {

        int n = nums.length;

        int[] maxLeft = new int[n];
        int[] minRight = new int[n];

        maxLeft[0] = nums[0];
        minRight[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], nums[i]);
        }
        for (int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(minRight[i + 1], nums[i]);

        }

        int ans[] = new int[n];
        ans[n - 1] = maxLeft[n - 1];

        for (int i = n - 2; i >= 0; i--) {

            if (maxLeft[i] <= minRight[i + 1]) {
                ans[i] = maxLeft[i];
            } else {
                ans[i] = ans[i + 1];
            }

        }

        return ans;

    }

}
