package com.dsa.BinarySearch.BS1DArray;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {

        int[] nums = { 5, 7, 7, 8, 8, 10 };
        int target = 8;

        int[] count = getFirstAndLastPosition(nums, target);

        System.out.println(count[1] - count[0] + 1);

        System.out.println(Arrays.toString(count));

    }

    public static int[] getFirstAndLastPosition(int[] nums, int target) {

        int lowerBound = getLowerBound(nums, target);

        if (lowerBound == nums.length || nums[lowerBound] != target) {
            return new int[] { -1, -1 };
        } else {
            return new int[] { lowerBound, getUpperBound(nums, target) - 1 };
        }

    }

    // lower bound is the first occurrence of the target element in the array
    // upper bound is the last occurrence of the target element in the array
    public static int getLowerBound(int[] nums, int target) {

        int index = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;
                index = mid;
            } else {
                low = mid + 1;
            }

        }
        return index;

    }

    public static int getUpperBound(int[] nums, int target) {

        int index = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid - 1;
                index = mid;
            } else {
                low = mid + 1;
            }

        }
        return index;

    }

}
