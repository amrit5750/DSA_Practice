package com.dsa.dp.TwoDarray;

public class CherryPickTwo {

    public static void main(String[] args) {

        int[][] grid = { { 3, 1, 1 }, { 2, 5, 1 }, { 1, 5, 5 }, { 2, 1, 1 } };
        System.out.println(cherryPickup(grid));

    }

    public static int cherryPickup(int[][] grid) {

        int row = 0;
        int col1 = 0;
        int col2 = grid[0].length - 1;
        Integer[][][] dp = new Integer[grid.length + 1][grid[0].length + 1][grid[0].length];
        return cherryPickupHelper(grid, row, col1, col2, dp);

    }

    public static int cherryPickupHelper(int[][] grid, int row, int col1, int col2, Integer[][][] dp) {

        if (row == grid.length) {
            return 0;
        }
        int cherry = grid[row][col1];
        if (col1 != col2) {
            cherry += grid[row][col2];
        }

        int ans = 0;

        if (dp[row][col1][col2] != null) {
            return dp[row][col1][col2];
        }

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {

                int newRow = row + 1;
                int newCol1 = col1 + i;
                int newCol2 = col2 + j;

                if (newCol1 >= 0 && newCol1 < grid[0].length && newCol2 >= 0 && newCol2 < grid[0].length) {
                    ans = Math.max(ans, cherryPickupHelper(grid, newRow, newCol1, newCol2, dp));
                }

            }
        }
        return dp[row][col1][col2] = cherry + ans;
    }

}
