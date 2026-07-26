package com.dsa.dailyDigest;

public class MaxConsistentColumns {

    public static void main(String[] args) {
        int[][] grid = { { -2, 0, 3 } };
        int limit = 2;
        System.out.println(maxConsistentColumns(grid, limit));

    }

    public static int maxConsistentColumns(int[][] grid, int limit) {

        int n = grid.length; // rows
        int m = grid[0].length; // cols
        Integer[][] dp = new Integer[252][252];
        int toBeDeleted = helper(grid, -1, 0, limit, n, m, dp);

        return m - toBeDeleted;

    }

    public static int helper(int[][] grid, int prevCol, int col, int limit, int rows, int cols, Integer[][] dp) {
        if (col == cols) {
            return 0;
        }

        if (dp[col][prevCol + 1] != null) {
            return dp[col][prevCol + 1];
        }

        int delete = 1 + helper(grid, prevCol, col + 1, limit, rows, cols, dp);
        int notDelete = Integer.MAX_VALUE;
        if (prevCol == -1 || isConsistent(col, prevCol, grid, limit)) {
            notDelete = helper(grid, col, col + 1, limit, rows, cols, dp);

        }
        return dp[col][prevCol + 1] = Math.min(delete, notDelete);

    }

    public static boolean isConsistent(int col, int prevCol, int[][] grid, int limit) {

        for (int row = 0; row < grid.length; row++) {
            if (Math.abs(grid[row][prevCol] - grid[row][col]) > limit) {
                return false;

            }

        }
        return true;
    }

}
