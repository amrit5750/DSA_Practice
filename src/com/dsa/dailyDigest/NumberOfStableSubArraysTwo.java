package com.dsa.dailyDigest;

public class NumberOfStableSubArraysTwo {

    static int MOD = 1_000_000_007;
    static int[][][] dp;

    public static void main(String[] args) {

        System.out.println(numberOfStableArrays(3, 3, 2));

    }

    public static int numberOfStableArrays(int zero, int one, int limit) {

        dp = new int[zero + 1][one + 1][2];

        for (int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }

        for (int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }

        for (int i = 0; i <= zero; i++) {
            for (int j = 0; j <= one; j++) {

                if (i == 0 || j == 0) {
                    continue;
                }

                if (j > 0) {
                    dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;

                    if (j - 1 >= limit) {
                        dp[i][j][1] = (dp[i][j][1] - dp[i][j - 1 - limit][0] + MOD) % MOD;
                    }

                }

                if (i > 0) {
                    dp[i][j][0] = (dp[i - 1][j][1] + dp[i - 1][j][0]) % MOD;

                    if (i - 1 >= limit) {
                        dp[i][j][0] = (dp[i][j][0] - dp[i - 1 - limit][j][1] + MOD) % MOD;
                    }

                }

            }
        }
        return (dp[zero][one][0] + dp[zero][one][1]) % MOD;

    }

}
