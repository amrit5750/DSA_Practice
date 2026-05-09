package com.dsa.arrays.medium;

//time complexity : O(n)
//space complexity : O(1)
//how it works?
// It uses Kadane's Algorithm
// It maintains a running sum and updates the maximum sum found so far
// It also keeps track of the start and end indices of the maximum subarray
public class MaximumSubarray {

    public static void main(String[] args) {

        int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        System.out.println(findMaximumSubarray(a));
    }

    public static int findMaximumSubarray(int[] nums) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }

            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
