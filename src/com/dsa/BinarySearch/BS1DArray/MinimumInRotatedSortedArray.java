package com.dsa.BinarySearch.BS1DArray;

public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {

        int[] nums = { 3, 4, 5, 1, 2 };

        System.out.println(getMin(nums));

    }

    public static int getMin(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];

    }

}
