package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {

    public static void main(String[] args) {
        int[] nums = { 4, 3, 5, 2 };

        System.out.println(powerSet(nums));

    }

    public static List<List<Integer>> powerSet(int[] nums) {

        List<List<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>());

        powerSethelper(nums, new ArrayList<>(), 0, list);

        return list;

    }

    public static void powerSethelper(int[] nums, List<Integer> current, int index, List<List<Integer>> list) {

        if (index == nums.length) {
            if (!current.isEmpty()) {
                list.add(new ArrayList<>(current));
            }
            return;
        }

        current.add(nums[index]);
        powerSethelper(nums, current, index + 1, list);
        current.remove(current.size() - 1);
        powerSethelper(nums, current, index + 1, list);

    }

}
