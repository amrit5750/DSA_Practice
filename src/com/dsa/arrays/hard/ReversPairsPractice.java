package com.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversPairsPractice {

    public static void main(String[] args) {

        // int[] nums = { 1, 3, 2, 3, 1 };
        int[] nums = { 2, 4, 3, 5, 1 };

        System.out.println(getPairs(nums));

    }

    public static int getPairs(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        return mergeSort(nums, low, high);

    }

    public static int getPairsCount(int[] nums, int low, int mid, int high) {

        int count = 0;
        int right = mid + 1;

        for (int i = low; i <= mid; i++) {

            while (right <= high && nums[i] > 2L * nums[right]) {

                right++;

            }

            count += right - (mid + 1);

        }

        return count;

    }

    public static int mergeSort(int[] nums, int low, int high) {

        int count = 0;

        if (low >= high) {
            return 0;
        }

        int mid = low + (high - low) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += getPairsCount(nums, low, mid, high);
        SortArrays(nums, low, mid, high);

        return count;

    }

    public static void SortArrays(int[] nums, int low, int mid, int high) {

        int left = low;
        int right = mid + 1;

        List<Integer> tempList = new ArrayList<>();

        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                tempList.add(nums[left]);
                left++;
            } else {
                tempList.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            tempList.add(nums[left]);
            left++;
        }

        while (right <= high) {
            tempList.add(nums[right]);
            right++;
        }

        for (int i = 0; i < tempList.size(); i++) {
            nums[low + i] = tempList.get(i);
        }

        System.out.println(Arrays.toString(nums));

    }

}
