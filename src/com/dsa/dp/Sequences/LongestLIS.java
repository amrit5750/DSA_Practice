package com.dsa.dp.Sequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestLIS {

    public static void main(String[] args) {

        int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
        System.out.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] nums) {

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int index = Collections.binarySearch(list, nums[i]);
            if (index < 0) {
                index = -(index + 1);
            }

            if (index == list.size()) {
                list.add(nums[i]);
            } else {
                list.set(index, nums[i]);
            }

        }

        return list.size();

    }

}
