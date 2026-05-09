package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class MaxPathScore {

    public static void main(String[] args) {

        int[][] grid = { { 0, 1 }, { 1, 2 } };
        int k = 1;

        System.out.println(maxPathScore(grid, k));

    }

    public static int maxPathScore(int[][] grid, int k) {

        Integer[][][] dp = new Integer[grid.length + 1][grid[0].length + 1][k + 1];
        return maxPathScoreHelper(grid, k, 0, 0, grid.length, grid[0].length, 0, dp);

    }

    public static int maxPathScoreHelper(int[][] grid, int k, int i, int j, int m, int n, int cost,
            Integer[][][] dp) {

        if (i >= m || j >= n) {
            return -1;
        }

        cost += (grid[i][j] == 1 || grid[i][j] == 2) ? 1 : 0;

        if (cost > k) {
            return -1;
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        if (dp[i][j][cost] != null) {
            return dp[i][j][cost];
        }

        int right = maxPathScoreHelper(grid, k, i + 1, j, m, n, cost, dp);
        int down = maxPathScoreHelper(grid, k, i, j + 1, m, n, cost, dp);

        int best = Math.max(right, down);
        if (best == -1) {
            return -1;
        }
        return dp[i][j][cost] = best + grid[i][j];

    }

}
