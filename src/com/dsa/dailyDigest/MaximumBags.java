package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaximumBags {
    public static void main(String[] args) {

        int[] capacity = { 2, 3, 4, 5 };
        int[] rocks = { 1, 2, 4, 4 };
        int additionalRocks = 2;
        System.out.println(maximumBags(capacity, rocks, additionalRocks));

    }

    public static int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {

        int[] required = new int[capacity.length];

        int n = required.length;
        for (int i = 0; i < n; i++) {
            required[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(required);

        int bags = 0;
        for (int i = 0; i < required.length; i++) {
            if (required[i] == 0) {
                bags++;
            } else if (additionalRocks > 0 && additionalRocks >= required[i]) {
                bags++;
                additionalRocks -= required[i];

            } else {
                break;

            }

        }
        return bags;

    }

}
