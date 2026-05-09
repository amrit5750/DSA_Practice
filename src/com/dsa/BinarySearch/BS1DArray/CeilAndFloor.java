package com.dsa.BinarySearch.BS1DArray;

import java.util.Arrays;

//ceil is the smallest element in the array which is greater than or equal to target
//floor is the largest element in the array which is less than or equal to target

public class CeilAndFloor {

    public static void main(String[] args) {

        int[] nums = { 3, 4, 4, 7, 8, 10 };
        int target = 5;

        int[] ans = new int[2];
        ans[0] = getCeil(nums, target);
        ans[1] = getFloor(nums, target);

        System.out.println(Arrays.toString(ans));
    }

    public static int getCeil(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int index = nums.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid - 1;

                index = nums[mid];
            } else {
                low = mid + 1;

            }

        }

        return index;

    }

    public static int getFloor(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        int index = nums.length;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] <= target) {
                low = mid + 1;
                index = nums[mid];
            } else {
                high = mid - 1;
            }

        }

        return index;

    }

}
