package com.dsa.contest.fourSeventyeight.foureightyNine;

import java.util.HashMap;
import java.util.Map;

public class FirstElementWithuniqueFrequnecy {

    public static void main(String[] args) {

        int[] nums = { 20, 10, 30, 30 };

        System.out.println(firstUniqueFreq(nums));

    }

    public static int firstUniqueFreq(int[] nums) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (int count : frequencyMap.values()) {
            countMap.put(count, countMap.getOrDefault(count, 0) + 1);
        }

        for (int num : nums) {
            if (countMap.get(frequencyMap.get(num)) == 1) {
                return num;
            }
        }
        return -1;

    }

}
