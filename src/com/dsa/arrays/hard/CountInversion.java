package com.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class CountInversion {

    public static void main(String[] args) {

        int[] nums = { 5, 3, 2, 4, 1 };

        // expected output is (5,3)(5,2)(5,4)(5,1)(3,2)(3,1)(2,1)(4,1)
        // i < j AND nums[i] > nums[j]
        System.out.println(getCountInversion(nums));

    }

    public static int getCountInversion(int[] nums) {

        return mergeSort(nums, 0, nums.length - 1);

    }

    public static int mergeSort(int[] nums, int low, int high) {
        int count = 0;

        if (low >= high) {
            return count;
        }

        int mid = (low + high) / 2;

        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += mergeArrays(nums, low, mid, high);
        return count;

    }

    public static int mergeArrays(int[] nums, int low, int mid, int high) {

        int count = 0;

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
                count += mid - left + 1;

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

        return count;

    }

}
