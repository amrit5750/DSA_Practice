package com.dsa.BiWeekly.OneSeventyEight;

import java.util.HashMap;
import java.util.Map;

public class FirstUniqueElement {

    public static void main(String[] args) {

        int[] nums = { 4, 4 };

        System.out.println(firstUniqueEven(nums));

    }

    public static int firstUniqueEven(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return -1;

    }
}
