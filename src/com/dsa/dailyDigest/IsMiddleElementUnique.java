package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class IsMiddleElementUnique {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3 };
        System.out.println(isMiddleElementUnique(nums));

    }

    public static boolean isMiddleElementUnique(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        int middle = nums.length / 2;

        return map.get(nums[middle]) > 1 ? false : true;

    }

}
