package com.dsa.greedy.easy.Medium;

import java.util.Arrays;

public class MinimumNumberofPlatforms {

    public static void main(String[] args) {

        int[] Arrival = { 900, 940, 950, 1100, 1500, 1800 };
        int[] Departure = { 910, 1200, 1120, 1130, 1900, 2000 };

        System.out.println(findPlatform(Arrival, Departure));

    }

    public static int findPlatform(int[] Arrival, int[] Departure) {

        int count = 1;

        int plaforms = 1;

        int i = 1;
        int j = 0;

        Arrays.sort(Arrival);
        Arrays.sort(Departure);
        while (i < Arrival.length && j < Departure.length) {
            if (Arrival[i] <= Departure[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }
            plaforms = Math.max(plaforms, count);
        }
        return plaforms;
    }
}
