package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class MakeSumDivisibleP {
    public static void main(String[] args) {
        int[] nums = { 3, 1, 4, 2 };
        int p = 6;
        System.out.println(minSubarray(nums, p));

    }

    public static int minSubarray(int[] nums, int p) {

        int sum = 0;
        for (int num : nums) {
            sum = (sum + num) % p;
        }
        int target = sum;

        if (target == 0)
            return 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int current = 0;
        int result = nums.length;

        for (int i = 0; i < nums.length; i++) {
            current = (current + nums[i]) % p;

            int remain = (current - target + p) % p;

            if (map.containsKey(remain)) {
                result = Math.min(result, i - map.get(remain));
            }

            map.put(current, i);
        }

        return result == nums.length ? -1 : result;
    }

}
