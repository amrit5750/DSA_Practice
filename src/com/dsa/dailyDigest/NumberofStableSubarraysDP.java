package com.dsa.dailyDigest;

public class NumberofStableSubarraysDP {

    static int MOD = 1_000_000_007;
    static Integer[][][] dp;

    public static void main(String[] args) {

        System.out.println(numberOfStableArrays(3, 3, 2));

    }

    public static int numberOfStableArrays(int one, int zero, int limit) {

        dp = new Integer[one + 1][zero + 1][2];
        dp[0][0][0] = 1;
        dp[0][0][1] = 1;

        for (int i = 0; i <= one; i++) {
            for (int j = 0; j <= zero; j++) {

                if (i == 0 && j == 0) {
                    continue;
                }

                int result = 0;

                for (int len = 1; len <= Math.min(i, limit); len++) {
                    result = (result + dp[i - len][j][1]) % MOD;
                }

                dp[i][j][0] = result;
                result = 0;
                for (int len = 1; len <= Math.min(j, limit); len++) {
                    result = (result + dp[i][j - len][0]) % MOD;
                }
                dp[i][j][1] = result;

            }

        }

        return (dp[one][zero][0] + dp[one][zero][1]) % MOD;

    }

}
