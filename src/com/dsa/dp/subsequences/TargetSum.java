package com.dsa.dp.subsequences;

import java.util.HashMap;
import java.util.Map;

public class TargetSum {

    public static void main(String[] args) {

        int[] nums = { 1 };
        int target = 1;
        System.out.println(findTargetSumWays(nums, target));

    }

    public static int findTargetSumWays(int[] nums, int target) {

        Map<String, Integer> map = new HashMap<>();
        return findTargetSumWaysHelper(nums, target, 0, 0, map);

    }

    public static int findTargetSumWaysHelper(int[] nums, int target, int index, int currentSum,
            Map<String, Integer> map) {

        if (index == nums.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }

        String key = index + "|" + currentSum;

        if (map.containsKey(key)) {
            return map.get(key);
        }

        int plus = findTargetSumWaysHelper(nums, target, index + 1, currentSum + nums[index], map);
        int minus = findTargetSumWaysHelper(nums, target, index + 1, currentSum - nums[index], map);
        int res = plus + minus;
        map.put(key, res);
        return res;

    }

}
