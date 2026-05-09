package com.dsa.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public record AggressiveCows() {

    public static void main(String[] args) {

        int[] stalls = { 0, 3, 4, 7, 10, 9 };

        int cows = 4;

        System.out.println(getMinDistance(stalls, cows));

    }

    public static int getMinDistance(int[] stalls, int cows) {

        Arrays.sort(stalls);

        int min = stalls[0];
        int max = stalls[stalls.length - 1];

        int ans = 0;

        int low = 1;
        int high = max - min;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canCowBePlaced(stalls, mid, cows)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;

    }

    private static boolean canCowBePlaced(int[] nums, int minDistance, int cows) {

        int cowsCount = 1;

        int lastCow = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - lastCow >= minDistance) {
                cowsCount++;
                lastCow = nums[i];
            }
        }

        return cowsCount >= cows;
    }

}
