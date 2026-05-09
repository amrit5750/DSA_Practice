package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2 };
        System.out.println(subsetsWithDup(nums));

    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, new ArrayList<>(), result);

        return result;
    }

    public static void subsetsWithDupHelper(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

        result.add(new ArrayList<>(current));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i - 1] == nums[i]) {
                continue;
            }
            current.add(nums[i]);
            subsetsWithDupHelper(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }

    }

}
