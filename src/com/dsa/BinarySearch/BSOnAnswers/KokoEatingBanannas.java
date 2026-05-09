package com.dsa.BinarySearch.BSOnAnswers;

public class KokoEatingBanannas {

    public static void main(String[] args) {

        int[] piles = { 3, 6, 7, 11 };
        int hours = 8;

        System.out.println(minEatingSpeed(piles, hours));

    }

    public static int minEatingSpeed(int[] piles, int h) {

        int k = 0;
        int low = 1;
        int high = 0;
        for (int pile : piles) {
            high = Math.max(high, pile);
        }

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int totalHours = getTotalHours(piles, mid);

            if (totalHours <= h) {
                high = mid - 1;
                k = mid;
            } else {
                low = mid + 1;

            }
        }

        return k;

    }

    public static int getTotalHours(int[] num, int k) {

        int totalHours = 0;

        for (int i = 0; i < num.length; i++) {

            totalHours += Math.ceil((double) num[i] / k);
        }

        return totalHours;
    }

}
