package com.dsa.arrays.hard;

import java.util.HashMap;
import java.util.Map;

// Count of subarrays with sum equal to zero
//time complexity : O(n)
//space complexity : O(n)
//how it works:
//use a hashmap to store the prefix sum and its frequency
//iterate through the array and keep adding the elements to the sum
//if the sum is already present in the hashmap, it means there are some subarrays with sum zero
//add the frequency of the sum to the count
//update the frequency of the sum in the hashmap    

public class NumberOfSubarraySumEqualsZero {

    public static void main(String[] args) {

        int[] nums = { 9, -3, 3, -1, 6, -5 };

        System.out.println(numberofSubArrrays(nums));

    }

    public static int numberofSubArrrays(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;

        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {

            sum += nums[i];

            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }

        return count;

    }

}
