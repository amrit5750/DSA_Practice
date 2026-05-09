package com.dsa.arrays.hard;

import java.util.HashMap;
import java.util.Map;

// Count of subarrays with given XOR k
//time complexity : O(n)
//space complexity : O(n)
//how it works:
//use a hashmap to store the prefix xor and its frequency
//iterate through the array and keep calculating the xor
//if the xor ^ k is already present in the hashmap, it means there are some subarrays with given xor k
//add the frequency of (xor ^ k) to the count
//update the frequency of the xor in the hashmap   

//if xor ^ k is present in map, it means there exists a prefix subarray with xor value equal to xor ^ k
//let's say the prefix xor up to index j is p_j and the prefix xor up to index i is p_i
//if p_i ^ p_j = k, then p_j = p_i ^ k
//this means that the subarray from index i+1 to j has xor value equal to k
//hence we add the frequency of p_j (which is xor ^ k) to the count

// it is similar to the approach used in finding the number of subarrays with sum equal to k
// we use prefix sums there, here we use prefix xors

public class CountOfSubarraysGivenXor {

    public static void main(String[] args) {

        int[] nums = { 4, 2, 2, 6, 4 };

        System.out.println(countOfSubarrays(nums, 6));

    }

    public static int countOfSubarrays(int[] nums, int k) {

        int count = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int xor = 0;

        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {

            xor = xor ^ nums[i];

            if (map.containsKey(xor ^ k)) {
                count += map.get(xor ^ k);

            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);

        }

        return count;
    }

}
