package com.dsa.dp.subsequences;

//time complexity - O(n*W)
public class UnboundedKnapSack {
    public static void main(String[] args) {

        int[] val = { 10, 40, 50, 70 };
        int[] wt = { 1, 3, 4, 5 };
        int W = 8;

        System.out.println(unboundedKnapsack(wt, val, val.length, W));

    }

    public static int unboundedKnapsack(int[] wt, int[] val, int n, int W) {
        Integer[][] dp = new Integer[W + 1][wt.length];
        return unboundedKnapsackHelper(wt, val, n, W, 0, dp);
    }

    public static int unboundedKnapsackHelper(int[] wt, int[] val, int n, int W, int index, Integer[][] dp) {

        if (index == n) {
            return 0;
        }

        if (dp[W][index] != null) {
            return dp[W][index];
        }

        int notPick = unboundedKnapsackHelper(wt, val, n, W, index + 1, dp);
        int pick = 0;
        if (wt[index] <= W) {
            pick = val[index] + unboundedKnapsackHelper(wt, val, n, W - wt[index], index, dp);
        }
        return dp[W][index] = Math.max(pick, notPick);

    }

}
