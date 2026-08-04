package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindMissingElements {

    public static void main(String[] args) {

    }

    public static List<Integer> findMissingElements(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Set<Integer> set = new HashSet<>();

        for (Integer num : nums) {
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        List<Integer> missIntegers = new ArrayList<>();

        for (int i = min; i <= max; i++) {
            if (!set.contains(i)) {
                missIntegers.add(i);
            }

        }

        return missIntegers;

    }

}
