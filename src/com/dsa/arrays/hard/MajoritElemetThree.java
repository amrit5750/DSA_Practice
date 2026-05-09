package com.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajoritElemetThree {

    public static void main(String[] args) {

        int[] nums = { 3, 2, 3 };

        List<Integer> majorIntegers = new ArrayList<>();

        majorIntegers = majorityElementBetterApproach(nums);

        majorIntegers.stream().forEach(ele -> System.out.println(ele));

    }

    public static List<Integer> majorityElementBetterApproach(int[] nums) {

        List<Integer> majIntegers = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        int minOccurances = nums.length / 3 + 1;

        for (int i = 0; i < nums.length; i++) {

            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }

            if (map.get(nums[i]) >= minOccurances && !majIntegers.contains(nums[i])) {
                majIntegers.add(nums[i]);
            }

            if (majIntegers.size() > 2) {
                break;
            }

        }

        return majIntegers;

    }

    // optimal approach - Boyer-Moore Voting Algorithm
    // time complexity : O(n)
    // space complexity : O(1)
    // how it works?
    // It maintains two count and two candidate elements
    // It iterates through the array and updates the counts and candidates based on
    // the current element
    // Finally, it verifies the candidates by counting their occurrences in the
    // array

    public static List<Integer> majorityElementOptimal(int[] nums) {

        List<Integer> majIntegers = new ArrayList<>();

        int ele1 = Integer.MIN_VALUE;
        int ele2 = Integer.MAX_VALUE;

        int count1 = 0;
        int count2 = 0;

        int minimumOccurances = nums.length / 3 + 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != ele2 && count1 == 0) {
                ele1 = nums[i];
                count1++;

            } else if (nums[i] != ele1 && count2 == 0) {
                ele2 = nums[i];
                count2++;
            } else if (nums[i] == ele1) {
                count1++;
            } else if (nums[i] == ele2) {
                count2++;
            } else {
                count1--;
                count2--;
            }

        }

        count1 = 0;
        count2 = 0;

        // why we need to verify?
        // because the candidates may not be the majority elements
        // for example, in the array [1,2,3,4], the candidates will be 3 and 4 but none
        // of them are majority elements
        // here ele1 = 3, ele2 = 4 but both occurs only once which is less than n/3 =
        // 1.33
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == ele1) {
                count1++;
            }
            if (nums[i] == ele2) {
                count2++;
            }

        }

        if (count1 >= minimumOccurances) {
            majIntegers.add(ele1);
        }
        if (count2 >= minimumOccurances && ele1 != ele2) {
            majIntegers.add(ele2);
        }

        return majIntegers;

    }

}
