package com.dsa.dailyDigest;

import java.util.Arrays;

public class StoneGame {
    public static void main(String[] args) {
        int[] piles = { 5, 3, 4, 5 };
        System.out.println(stoneGame(piles));

    }

    public static boolean stoneGame(int[] piles) {

        int sum = Arrays.stream(piles).sum();
        Integer[][] dp = new Integer[501][501];
        int aliceScore = stoneGameHelper(piles, 0, piles.length - 1, dp);
        return aliceScore > sum - aliceScore ? true : false;

    }

    public static int stoneGameHelper(int[] piles, int i, int j, Integer[][] dp) {

        if (i > j)
            return 0;

        // Only one number left
        if (i == j)
            return piles[i];

        // Two numbers left
        if (i + 1 == j)
            return Math.max(piles[i], piles[j]);

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int take_i = piles[i]
                + Math.min(stoneGameHelper(piles, i + 2, j, dp), stoneGameHelper(piles, i + 1, j - 1, dp));
        int take_j = piles[j]
                + Math.min(stoneGameHelper(piles, i + 1, j - 1, dp), stoneGameHelper(piles, i, j - 2, dp));
        return dp[i][j] = Math.max(take_i, take_j);

    }

}
