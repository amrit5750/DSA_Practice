package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.TreeSet;

public class MinAbsDiffSlidingWindow {

    public static void main(String[] args) {

        int[][] grid = { { 1, -2, 3 }, { 2, 3, 5 } };
        int k = 2;

        System.out.println(Arrays.deepToString(minAbsDiff(grid, k)));

    }

    public static int[][] minAbsDiff(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][] result = new int[m - k + 1][n - k + 1];

        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {

                TreeSet<Integer> set = new TreeSet<>();
                int p = 0;

                int q = 0;

                for (p = i; p < i + k; p++) {
                    for (q = j; q < j + k; q++) {
                        set.add(grid[p][q]);
                    }
                }

                if (set.size() == 1) {
                    result[i][j] = 0;
                    continue;

                }

                int minValue = Integer.MAX_VALUE;
                Integer prev = null;

                for (Integer num : set) {
                    if (prev != null) {
                        minValue = Math.min(minValue, num - prev);
                    }
                    prev = num;
                }

                result[i][j] = minValue;
            }
        }
        return result;
    }

}
