package com.dsa.dailyDigest;

public class MinimumSeconds {

    public static void main(String[] args) {

        int mountainHeight = 4;
        int[] workerTimes = { 2, 1, 1 };

        System.out.println(minNumberOfSeconds(mountainHeight, workerTimes));

    }

    public static boolean check(long mid, int[] workerTimes, int mountainHeight) {

        long height = 0;

        for (int i : workerTimes) {
            long k = (long) (Math.sqrt(((2.0 * mid) / i) + 0.25) - 0.5);

            height += k;

            if (height >= mountainHeight) {
                return true;
            }
        }
        return height >= mountainHeight;

    }

    public static long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        long low = 1;
        long high = (long) 1e14;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(mid, workerTimes, mountainHeight)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;

    }

}
