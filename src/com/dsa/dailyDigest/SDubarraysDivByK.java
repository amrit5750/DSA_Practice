package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class SDubarraysDivByK {

    public static void main(String[] args) {

        int[] nums = { 4, 5, 0, -2, -3, 1 };

        int k = 5;

        System.out.println(subarraysDivByK(nums, k));

    }

    public static int subarraysDivByK(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        int count = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int mod = sum % k;

            if (mod < 0) {
                mod += k;
            }
            if (map.containsKey(mod)) {
                count += map.get(mod);
            }

            map.put(mod, map.getOrDefault(mod, 0) + 1);

        }
        return count;

    }

}
