package com.dsa.slidingwindow.medium;

public class NumberofSubArraysWithSumK {

    public static void main(String[] args) {

        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal) - numSubarraysWithSum(nums, goal - 1));

    }

    public static int numSubarraysWithSum(int[] nums, int goal) {

        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        if (goal < 0) {
            return 0;
        }

        while (right < nums.length) {
            sum += nums[right];

            while (sum > goal) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

}
