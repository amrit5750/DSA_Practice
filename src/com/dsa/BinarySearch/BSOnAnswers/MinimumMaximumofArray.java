package com.dsa.BinarySearch.BSOnAnswers;

public class MinimumMaximumofArray {

    public static void main(String[] args) {

        int[] nums = { 5, 1, 10, 1, 5 };

        System.out.println(minimizeArrayValue(nums));

    }

    public static int minimizeArrayValue(int[] nums) {

        int res = 0;
        int low = 0;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length - 1; i++) {

            high = Math.max(high, nums[i]);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, 6)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return res;

    }

    public static boolean isValid(int[] nums, int maxmid) {

        long buffer = 0;

        for (int i = nums.length - 1; i >= 0; i--) {

            long curr = nums[i] + buffer;

            if (curr > maxmid) {
                buffer = curr - maxmid;

            } else {
                buffer = 0;
            }

        }

        return buffer == 0;

    }

}
