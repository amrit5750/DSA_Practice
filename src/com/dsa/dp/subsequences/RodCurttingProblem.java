package com.dsa.dp.subsequences;

//time complexity is O(n*n)
public class RodCurttingProblem {

    public static void main(String[] args) {

        int[] price = { 1, 6, 8, 9, 10, 19, 7, 20 };
        int N = 8;
        System.out.println(RodCutting(price, N));

    }

    public static int RodCutting(int price[], int n) {
        Integer[][] dp = new Integer[n + 1][n + 1];
        return RodCuttingHelper(price, n, 1, dp);

    }

    public static int RodCuttingHelper(int price[], int n, int length, Integer[][] dp) {

        if (n == 0) {
            return 0;
        }

        if (dp[n][length] != null) {
            return dp[n][length];
        }
        int pick = 0;
        if (length <= n) {
            pick = price[length - 1] + RodCuttingHelper(price, n - length, length, dp);
        }
        int notPick = 0;

        if (length < price.length) {
            notPick = RodCuttingHelper(price, n, length + 1, dp);
        }

        return dp[n][length] = Math.max(pick, notPick);

    }

}
