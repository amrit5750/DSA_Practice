package com.dsa.BinarySearch.BSOnAnswers;

public class SplitArrayLargestSum {

    public static void main(String[] args) {

        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        System.out.println(splitArray(nums, k));
    }

    public static int splitArray(int[] nums, int k) {
        int low = Integer.MIN_VALUE;
        int high = 0;

        for (int i = 0; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;
            if (getSubarrays(nums, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

    public static boolean getSubarrays(int[] nums, int k, int mid) {

        int sububarrays = 1;
        int lastSubArray = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (lastSubArray + nums[i] <= mid) {
                lastSubArray += nums[i];
            } else {
                sububarrays++;
                lastSubArray = nums[i];

            }

        }

        return sububarrays <= k;

    }

}
