package com.dsa.dp.TwoDarray;

public class NinjaTraining {

    public static void main(String[] args) {

        int[][] matrix = { { 10, 40, 70 }, { 20, 50, 80 }, { 30, 60, 90 } };

        System.out.println(ninjaTraining(matrix));

    }

    public static int ninjaTraining(int[][] matrix) {

        Integer[][] dp = new Integer[matrix.length][4];

        return ninjaTrainingHelper(matrix, matrix.length - 1, 3, dp);

    }

    public static int ninjaTrainingHelper(int[][] matrix, int days, int last, Integer[][] dp) {

        if (dp[days][last] != null) {
            return dp[days][last];
        }

        if (days == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Math.max(max, matrix[0][i]);
                }
            }
            return dp[days][last] = max;
        }

        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                int points = matrix[days][i] + ninjaTrainingHelper(matrix, days - 1, i, dp);
                max = Math.max(max, points);
            }

        }
        return dp[days][last] = max;
    }

}
