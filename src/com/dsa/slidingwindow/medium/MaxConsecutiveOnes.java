package com.dsa.slidingwindow.medium;

public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;

        System.out.println(longestOnes(nums, k));

    }

    public static int longestOnes(int[] nums, int k) {

        int len = 0;
        int left = 0;
        int right = 0;
        int zeros = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeros++;
            }
            while (zeros > k) {
                if (nums[left] == 0) {
                    zeros--;
                }
                left++;
            }

            if (zeros <= k) {
                len = Math.max(len, right - left + 1);
            }
            right++;
        }
        return len;
    }

}
