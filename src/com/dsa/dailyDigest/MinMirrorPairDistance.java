package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class MinMirrorPairDistance {

    public static void main(String[] args) {

        int[] nums = { 12, 21, 45, 33, 54 };
        System.out.println(minMirrorPairDistance(nums));

    }

    public static int getReverse(int n) {
        int rev = 0;

        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n /= 10;
        }
        return rev;
    }

    public static int minMirrorPairDistance(int[] nums) {
        int min = Integer.MAX_VALUE;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                min = Math.min(min, i - map.get(nums[i]));
            }

            map.put(getReverse(nums[i]), i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }

}
