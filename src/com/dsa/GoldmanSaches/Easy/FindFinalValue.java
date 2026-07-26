package com.dsa.GoldmanSaches.Easy;

import java.util.HashMap;
import java.util.Map;

public class FindFinalValue {
    public static void main(String[] args) {

        int[] nums = { 5, 3, 6, 1, 12 };
        int original = 3;
        System.out.println(findFinalValue(nums, original));

    }

    public static int findFinalValue(int[] nums, int original) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        while (map.containsKey(original)) {
            original = original * 2;

        }
        return original;

    }

}
