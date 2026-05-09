package com.dsa.arrays.medium;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Lcs {

    public static void main(String[] args) {

        int[] nums = { 100, 4, 200, 1, 3, 2 };

        System.out.println(longestConsecutive(nums));

    }

    public static int longestConsecutive(int[] nums) {

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
