package com.dsa.BinarySearch.BS1DArray;

//to find the first position where element is greater than n
//upper bound implementation
public class implementUpperBound {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3, 5 };

        int n = 2;

        System.out.println(getupperBound(nums, n));

    }

    public static int getupperBound(int[] nums, int n) {

        int index = -1;

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > n) {
                index = mid;
                high = mid - 1;
            } else {

                low = mid + 1;

            }

        }

        return index;

    }

}
