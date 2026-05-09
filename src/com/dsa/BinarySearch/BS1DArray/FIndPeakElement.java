package com.dsa.BinarySearch.BS1DArray;

public class FIndPeakElement {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1, 3, 5, 6, 4 };

        System.out.println(findPeakElement(nums));

    }

    public static int findPeakElement(int[] nums) {

        int low = 1;
        int high = nums.length - 2;
        int n = nums.length;

        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }

        if (nums[n - 1] > nums[n - 2]) {
            return n - 1;
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (nums[mid - 1] < nums[mid]) {
                low = mid + 1;
            } else if (nums[mid - 1] > nums[mid]) {
                high = mid - 1;
            }
            // As peak can exists in any direction so i can move in any direction
            else {
                low = mid + 1;
            }

        }

        return -1;

    }

}
