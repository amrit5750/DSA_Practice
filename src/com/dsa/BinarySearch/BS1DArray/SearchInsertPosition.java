package com.dsa.BinarySearch.BS1DArray;

public class SearchInsertPosition {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 6 };

        System.out.println(getInsertPosition(nums, 5));

    }

    public static int getInsertPosition(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;

        int index = nums.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return index;

    }

}
