package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class countMajoritySubarraysTwo {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3 };
        int target = 2;
        System.out.println(countMajoritySubarrays(nums, target));

    }

    public static long countMajoritySubarrays(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // commulative sum and count;

        long validPoints = 0;
        long result = 0;
        int cumSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                validPoints += map.getOrDefault(cumSum, 0);
                cumSum++;
            } else {
                cumSum--;
                validPoints -= map.getOrDefault(cumSum, 0);

            }

            map.merge(cumSum, 1, Integer::sum);
            result += validPoints;

        }

        return result;

    }

}
