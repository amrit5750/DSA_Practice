package com.dsa.BinarySearch.BS1DArray;

//to find the first position where element is greater than or equal to n
//lower bound implementation
public class ImplementLowerBound {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3 };
        int n = 2;

        System.out.println(getlowerBound(nums, n));

    }

    public static int getlowerBound(int[] nums, int n) {

        int index = nums.length;
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= n) {
                index = mid;
                high = mid - 1;

            } else {
                low = mid + 1;

            }
        }

        return index;

    }

}
