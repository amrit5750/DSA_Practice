package com.dsa.BinarySearch.BS1DArray;

public class BinarySearch {

    public static void main(String[] args) {

        int[] nums = { -1, 0, 3, 5, 9, 12 };

        System.out.println(getElementIndex(nums, 9));

    }

    public static int getElementIndex(int[] nums, int ele) {

        int index = -1;
        int low = 0;
        int n = nums.length;
        int high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == ele) {
                return mid;
            } else if (nums[mid] < ele) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return index;

    }

}
