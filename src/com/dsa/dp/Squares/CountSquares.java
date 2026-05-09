package com.dsa.dp.Squares;

public class CountSquares {
    public static void main(String[] args) {

        int[][] matrix = {
                { 0, 1, 1, 1 },
                { 1, 1, 1, 1 },
                { 0, 1, 1, 1 }
        };

        System.out.println(countSquares(matrix));

    }

    private static int solve(int[][] matrix, int i, int j, int m, int n, Integer[][] dp) {

        if (i >= m || j >= n) {
            return dp[i][j] = 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (matrix[i][j] == 0) {
            return dp[i][j] = 0;
        }

        int right = solve(matrix, i, j + 1, m, n, dp);
        int down = solve(matrix, i + 1, j, m, n, dp);
        int diagonal = solve(matrix, i + 1, j + 1, m, n, dp);

        return dp[i][j] = 1 + Math.min(right, Math.min(down, diagonal));

    }

    public static int countSquares(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;
        Integer[][] dp = new Integer[301][301];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result += solve(matrix, i, j, m, n, dp);
            }
        }

        return result;

    }

}
