package com.dsa.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public static void main(String[] args) {

        int[] nums = { 43, 54, 22, 43, 23, 12, 87, 44 };
        mergesort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void mergesort(int[] nums) {

        int low = 0;
        int high = nums.length - 1;

        mergesortHelper(nums, low, high);

    }

    public static void mergesortHelper(int[] nums, int low, int high) {

        int mid = low + (high - low) / 2;

        if (low < high) {
            mergesortHelper(nums, low, mid);
            mergesortHelper(nums, mid + 1, high);
            merge(nums, low, mid, high);
        }
    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> temp = new ArrayList<>();
        while (left <= mid && right <= high) {

            if (nums[left] <= nums[right]) {
                temp.add(nums[left]);
                left++;
            } else {
                temp.add(nums[right]);
                right++;
            }
        }

        while (left <= low) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);
            right++;
        }

        for (int i = 0; i < temp.size(); i++) {
            nums[low + i] = temp.get(i);

        }

    }

}
