package com.dsa.dailyDigest;

import java.util.Arrays;

public class MinimumEffort {

    public static void main(String[] args) {

        int[][] tasks = { { 1, 2 }, { 2, 4 }, { 4, 8 } };
        System.out.println(minimumEffort(tasks));

    }

    public static int minimumEffort(int[][] tasks) {

        Arrays.sort(tasks, (a, b) -> Integer.compare((b[1] - b[0]), (a[1] - a[0])));

        int low = 0;
        int high = Integer.MAX_VALUE;
        int minEnergy = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleToCompleteAllTasks(tasks, mid)) {
                high = mid - 1;
                minEnergy = Math.min(minEnergy, mid);
            } else {
                low = mid + 1;

            }
        }
        return minEnergy;
    }

    public static boolean isPossibleToCompleteAllTasks(int[][] tasks, int initialEnergy) {

        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i][1] > initialEnergy) {
                return false;
            }
            initialEnergy = initialEnergy - tasks[i][0];
        }

        return true;

    }

}
