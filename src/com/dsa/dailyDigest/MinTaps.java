package com.dsa.dailyDigest;

public class MinTaps {

    public static void main(String[] args) {
        int n = 5;
        int[] ranges = { 3, 4, 1, 1, 0, 0 };
        System.out.println(minTaps(n, ranges));

    }

    public static int minTaps(int n, int[] ranges) {

        int[] startRange = new int[n + 1];
        for (int i = 0; i < startRange.length; i++) {

            int start = Math.max(0, i - ranges[i]);
            int end = Math.min(n, i + ranges[i]);
            startRange[start] = Math.max(startRange[start], end);
        }

        int taps = 1;
        // int maxEnd = 0;
        // int currentEnd = 0;
        // for (int i = 0; i < n + 1; i++) {

        // if (i > maxEnd) {
        // return -1;
        // }

        // if (i > currentEnd) {
        // taps++;
        // currentEnd = maxEnd;
        // }

        // maxEnd = Math.max(maxEnd, startRange[i]);

        // }

        int currentMax = startRange[0];
        for (int i = 1; i < startRange.length; i++) {
            if (startRange[i] > currentMax) {
                taps++;
                currentMax = startRange[i];
            }

        }

        return taps;

    }

}
