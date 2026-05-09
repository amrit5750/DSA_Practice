package com.dsa.dp.TwoDarray;

public class MinPathSum {

    public static void main(String[] args) {

        int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };

        System.out.println(minPathSum(grid));

    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Integer[][] dp = new Integer[m][n];
        return minPathSumHelper(grid, m, n, 0, 0, dp);

    }

    public static int minPathSumHelper(int[][] grid, int m, int n, int i, int j, Integer[][] dp) {

        if (i < 0 || j < 0 || i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i == m - 1 && j == n - 1) {
            return grid[i][j];
        }

        int right = minPathSumHelper(grid, m, n, i + 1, j, dp);
        int down = minPathSumHelper(grid, m, n, i, j + 1, dp);

        return dp[i][j] = grid[i][j] + Math.min(right, down);
    }
}
