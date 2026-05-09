package com.dsa.dp.TwoDarray;

public class UniquePaths {

    public static void main(String[] args) {

        System.out.println(uniquePaths(3, 7));

    }

    public static int uniquePaths(int m, int n) {

        Integer[][] dp = new Integer[m + 1][n + 1];
        return uniquePathsHelper(m, n, 0, 0, dp);

    }

    public static int uniquePathsHelper(int m, int n, int i, int j, Integer[][] dp) {

        if (i == m - 1 && j == n - 1) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (i < 0 || i >= m || i < 0 || j >= n) {
            return 0;
        }
        int down = uniquePathsHelper(m, n, i + 1, j, dp);
        int right = uniquePathsHelper(m, n, i, j + 1, dp);

        return dp[i][j] = right + down;

    }

}
