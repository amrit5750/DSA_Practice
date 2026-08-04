package com.dsa.dailyDigest;

public class StoneGameTwo {

    static int n = 0;

    public static void main(String[] args) {

        int[] piles = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameII(piles));

    }

    public static int stoneGameII(int[] piles) {
        n = piles.length;
        Integer[][][] dp = new Integer[2][n][n + 1];
        return stoneGameIIHelper(piles, 1, 0, 1, dp);

    }

    public static int stoneGameIIHelper(int[] piles, int person, int i, int M, Integer[][][] dp) {

        if (i >= n) {
            return 0;
        }

        if (dp[person][i][M] != null) {
            return dp[person][i][M];
        }
        int result = dp[person][i][M] = person == 1 ? -1 : Integer.MAX_VALUE;

        int stones = 0;

        for (int X = 1; X <= Math.min(2 * M, n - i); X++) {

            stones += piles[i + X - 1];

            if (person == 1) {
                result = dp[person][i][M] = Math.max(result,
                        stones + stoneGameIIHelper(piles, 0, i + X, Math.max(M, X), dp));

            } else {
                result = dp[person][i][M] = Math.min(result, stoneGameIIHelper(piles, 1, i + X, Math.max(M, X), dp));

            }

        }
        return dp[person][i][M] = result;

    }

}
