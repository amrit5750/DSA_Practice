package com.dsa.dailyDigest;

import java.util.HashSet;
import java.util.Set;

public class UniqueXorTripletsTwo {

    public static void main(String[] args) {

        int[] nums = { 1, 3 };

        System.out.println(uniqueXorTriplets(nums));

    }

    public static int uniqueXorTriplets(int[] nums) {
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                s1.add(nums[i] ^ nums[j]);
            }

        }

        for (int i = 0; i < nums.length; i++) {
            for (Integer ele : s1) {
                s2.add(ele ^ nums[i]);
            }

        }

        return s2.size();

    }

}
