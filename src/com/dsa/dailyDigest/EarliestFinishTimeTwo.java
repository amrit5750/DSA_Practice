package com.dsa.dailyDigest;

public class EarliestFinishTimeTwo {

    public static void main(String[] args) {

        int[] landStartTime = { 2, 8 };
        int[] landDuration = { 4, 1 };
        int[] waterStartTime = { 6 };
        int[] waterDuration = { 3 };

        System.out.println(earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration));

    }

    public static int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime,
            int[] waterDuration) {

        int firstWater = calc(waterStartTime, waterDuration, landStartTime, landDuration);
        int firstLand = calc(landStartTime, landDuration, waterStartTime, waterDuration);

        return Math.min(firstWater, firstLand);

    }

    public static int calc(int[] firstStart, int[] firstDuration, int[] secondStart,
            int[] secondDuration) {

        int firstMin = Integer.MAX_VALUE;
        for (int i = 0; i < firstDuration.length; i++) {
            firstMin = Math.min(firstMin, firstStart[i] + firstDuration[i]);

        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < secondDuration.length; i++) {
            ans = Math.min(ans, Math.max(firstMin, secondStart[i]) + secondDuration[i]);

        }

        return ans;

    }

}
