package com.dsa.slidingwindow.hard;

import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKdifferentIntegers {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1, 3, 4 };
        int k = 3;

        System.out.println(numberOfSubarrays(nums, k) - numberOfSubarrays(nums, k - 1));

    }

    public static int numberOfSubarrays(int[] nums, int k) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);

                if (map.get(nums[left]) <= 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            count += i - left + 1;
        }

        return count;

    }

}
