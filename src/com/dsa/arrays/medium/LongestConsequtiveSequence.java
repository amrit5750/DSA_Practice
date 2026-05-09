package com.dsa.arrays.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsequtiveSequence {

    public static void main(String[] args) {

        int[] nums = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };

        System.out.println(getLongestSequence(nums));

    }

    public static int getLongestSequence(int[] nums) {

        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int count = 0;
        int longest = 0;

        for (Integer ele : set) {
            if (!set.contains(ele - 1)) {

                int seq = ele;
                longest++;

                while (set.contains(seq + 1)) {
                    seq++;
                    longest++;
                }

                count = Math.max(longest, count);
                longest = 0;

            }

        }
        return count;

    }

}
