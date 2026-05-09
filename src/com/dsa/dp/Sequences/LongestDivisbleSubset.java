package com.dsa.dp.Sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestDivisbleSubset {

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        System.out.println(largestDivisibleSubset(nums));

    }

    public static List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> map = new HashMap<>();
        return largestDivisibleSubsetHelper(nums, new ArrayList<>(), 0, -1, map);

    }

    public static List<Integer> largestDivisibleSubsetHelper(int[] nums, List<Integer> temp,
            int index, int prevElement, Map<String, List<Integer>> map) {

        if (index == nums.length) {
            return new ArrayList<>();

        }

        String key = String.valueOf(prevElement) + "|" + String.valueOf(index);

        if (map.containsKey(key)) {
            return map.get(key);
        }

        List<Integer> notTake = largestDivisibleSubsetHelper(nums, temp, index + 1, prevElement, map);
        List<Integer> take = new ArrayList<>();
        if (prevElement == -1 || nums[index] % prevElement == 0) {
            take.add(nums[index]);
            take.addAll(largestDivisibleSubsetHelper(nums, temp, index + 1, nums[index], map));
        }

        // not take

        List<Integer> result = take.size() > notTake.size() ? take : notTake;

        map.put(key, new ArrayList<>(result));
        return result;

    }

}
