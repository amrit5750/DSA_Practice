package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumDistance {
    public static void main(String[] args) {

        int[] nums = { 1, 1, 2, 3, 2, 1, 2 };
        System.out.println(minimumDistance(nums));

    }

    public static int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            map.computeIfAbsent(nums[j], k -> new ArrayList<>()).add(j);

        }
        int min = Integer.MAX_VALUE;
        boolean isFound = false;

        for (List<Integer> indexes : map.values()) {

            if (indexes.size() >= 3) {

                for (int i = 0; i <= indexes.size() - 3; i++) {
                    int first = indexes.get(i);
                    int third = indexes.get(i + 2);

                    int distance = 2 * (third - first);
                    min = Math.min(min, distance);
                    isFound = true;
                }
            }
        }

        return isFound == false ? -1 : min;

    }
}
