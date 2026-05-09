package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset1 {
    public static void main(String[] args) {
        int[] nums = { 5, 2, 1 };

        System.out.println(subsetSums(nums, 3));

    }

    public static List<Integer> subsetSums(int[] nums, int k) {

        List<Integer> list = new ArrayList<>();

        subsetSumsHelper(nums, 0, 0, list);

        Collections.sort(list);

        return list;

    }

    public static void subsetSumsHelper(int[] nums, int sum, int index, List<Integer> list) {

        if (index == nums.length) {
            list.add(sum);
            return;
        }
        subsetSumsHelper(nums, sum + nums[index], index + 1, list);
        subsetSumsHelper(nums, sum, index + 1, list);

    }
}
