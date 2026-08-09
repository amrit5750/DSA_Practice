package com.dsa.dailyDigest;

public class StonrGameTwoP {

    public static void main(String[] args) {
        int[] piles = { 2, 7, 9, 4, 4 };
        System.out.println(stoneGameII(piles));
    }

    public static int stoneGameII(int[] piles) {
        Integer[][][] dp = new Integer[101][101][2];
        int AliceStones = stoneGameIIHelper(1, 1, 0, piles.length, piles, dp);

        return AliceStones;

    }

    public static int stoneGameIIHelper(int person, int M, int index, int n, int[] piles, Integer[][][] dp) {

        if (index >= n) {
            return 0;
        }

        int stone = 0;
        if (dp[M][index] != null) {
            return dp[M][index][person];
        }
        int result = dp[M][index][person] = person == 1 ? -1 : Integer.MAX_VALUE;

        for (int X = 1; X <= Math.min(2 * M, n - index); X++) {
            stone += piles[index + X - 1];

            if (person == 1) {
                result = dp[M][index][person] = Math.max(result, stone +
                        stoneGameIIHelper(0, Math.max(M, X), index + X, n, piles, dp));
            } else {
                result = dp[M][index][person] = Math.min(result,
                        stoneGameIIHelper(1, Math.max(M, X), index + X, n, piles, dp));
            }

        }

        return result;
    }

}
