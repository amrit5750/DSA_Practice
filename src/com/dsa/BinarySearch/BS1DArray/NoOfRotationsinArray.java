package com.dsa.BinarySearch.BS1DArray;

public class NoOfRotationsinArray {

    public static void main(String[] args) {

        int[] nums = { 3, 4, 5, 1, 2 };

        System.out.println(getNoOfRotations(nums));

    }

    public static int getNoOfRotations(int[] nums) {
        int low = 0, high = nums.length - 1;

        if (nums[low] <= nums[high])
            return 0;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

}
