package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PivotArray {

    public static void main(String[] args) {

        int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 10;
        System.out.println(Arrays.toString(pivotArray(nums, pivot)));

    }

    public static int[] pivotArray(int[] nums, int pivot) {

        List<Integer> lesser = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                lesser.add(nums[i]);
            } else if (nums[i] == pivot) {
                equal.add(nums[i]);
            } else {
                greater.add(nums[i]);

            }
        }
        int[] ans = new int[nums.length];
        int i = 0;
        for (Integer ele : lesser) {
            ans[i] = ele;
            i++;
        }
        for (Integer ele : equal) {
            ans[i] = ele;
            i++;
        }
        for (Integer ele : greater) {
            ans[i] = ele;
            i++;
        }

        return ans;

    }

}
