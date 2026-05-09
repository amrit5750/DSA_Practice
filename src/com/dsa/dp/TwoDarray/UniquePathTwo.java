package com.dsa.dp.TwoDarray;

public class UniquePathTwo {
    public static void main(String[] args) {
        int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };

        System.out.println(uniquePathsWithObstacles(obstacleGrid));

    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        Integer[][] dp = new Integer[m + 1][n + 1];

        return uniquePathsWithObstaclesHelper(obstacleGrid, m, n, 0, 0, dp);

    }

    public static int uniquePathsWithObstaclesHelper(int[][] obstacleGrid, int m, int n, int i, int j, Integer[][] dp) {

        if (obstacleGrid[i][j] == 1)
            return 0;

        if (i < 0 || i >= m || j < 0 || j >= n) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int right = 0;
        if (i + 1 < m && obstacleGrid[i + 1][j] != 1) {
            right = uniquePathsWithObstaclesHelper(obstacleGrid, m, n, i + 1, j, dp);
        }

        int down = 0;
        if (j + 1 < n && obstacleGrid[i][j + 1] != 1) {
            down = uniquePathsWithObstaclesHelper(obstacleGrid, m, n, i, j + 1, dp);
        }

        return dp[i][j] = right + down;

    }

}
