package com.dsa.dailyDigest;

public class MaximumAmount {

    public static void main(String[] args) {

        int[][] coins = { { 0, 1, -1 }, { 1, -2, 3 }, { 2, -3, 4 } };
        System.out.println(maximumAmount(coins));

    }

    public static int maximumAmount(int[][] coins) {

        int rows = coins.length;
        int cols = coins[0].length;
        Integer[][][] dp = new Integer[rows + 1][cols + 1][3];
        return maximumAmountHelper(coins, 2, 0, 0, rows, cols, dp);

    }

    public static int maximumAmountHelper(int[][] coins, int neutral, int i, int j, int rows, int cols,
            Integer[][][] dp) {

        if (i == rows - 1 && j == cols - 1) {
            if (coins[i][j] < 0 && neutral > 0) {
                return 0;
            }
            return coins[i][j];
        }

        if (dp[i][j][neutral] != null) {
            return dp[i][j][neutral];
        }

        if (i < 0 || j < 0 || i >= rows || j >= cols) {
            return Integer.MIN_VALUE;
        }

        int take = coins[i][j] + Math.max(maximumAmountHelper(coins, neutral, i + 1, j, rows, cols, dp),
                maximumAmountHelper(coins, neutral, i, j + 1, rows, cols, dp));

        int skip = Integer.MIN_VALUE;
        if (coins[i][j] < 0 && neutral > 0) {

            int downSkip = maximumAmountHelper(coins, neutral - 1, i + 1, j, rows, cols, dp);
            int rightSkip = maximumAmountHelper(coins, neutral - 1, i, j + 1, rows, cols, dp);
            skip = Math.max(rightSkip, downSkip);

        }

        return dp[i][j][neutral] = Math.max(take, skip);

    }
}
