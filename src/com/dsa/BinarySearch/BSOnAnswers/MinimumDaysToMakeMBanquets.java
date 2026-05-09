package com.dsa.BinarySearch.BSOnAnswers;

public class MinimumDaysToMakeMBanquets {

    public static void main(String[] args) {

        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;

        System.out.println(minDays(bloomDay, m, k));

    }

    public static int minDays(int[] bloomDay, int m, int k) {

        if ((long) m * k > bloomDay.length)
            return -1;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < bloomDay.length; i++) {
            low = Math.min(low, bloomDay[i]);
            high = Math.max(high, bloomDay[i]);

        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canMake(bloomDay, mid, m, k)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static boolean canMake(int[] bloomDay, int day, int m, int k) {

        int bouquets = 0;
        int flowers = 0;

        for (int i : bloomDay) {
            if (i <= day) {
                flowers++;
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;
                }
            } else {
                flowers = 0;
            }

        }

        return bouquets >= m;
    }

}
