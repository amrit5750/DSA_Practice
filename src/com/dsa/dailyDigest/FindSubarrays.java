package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class FindSubarrays {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(findSubarrays(nums));

    }

    public static boolean findSubarrays(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            if (map.containsKey(nums[i] + nums[i + 1])) {
                return true;
            }
            map.put(nums[i] + nums[i + 1], i);
        }
        return false;
    }

}
