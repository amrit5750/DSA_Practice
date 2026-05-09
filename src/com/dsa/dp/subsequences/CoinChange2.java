package com.dsa.dp.subsequences;

public class CoinChange2 {

    public static void main(String[] args) {

        int amount = 10;
        int[] coins = { 10 };

        System.out.println(change(amount, coins));

    }

    public static int change(int amount, int[] coins) {
        Integer[][] dp = new Integer[coins.length + 1][amount + 1];
        return changeHelper(amount, coins, 0, 0, dp);

    }

    public static int changeHelper(int amount, int[] coins, int index, int currentSum, Integer[][] dp) {

        if (currentSum > amount)
            return 0;

        if (index == coins.length) {
            if (currentSum == amount) {
                return 1;
            }
            return 0;
        }

        if (dp[index][currentSum] != null) {
            return dp[index][currentSum];
        }
        int pick = 0;
        if (currentSum + coins[index] <= amount) {
            pick = changeHelper(amount, coins, index, currentSum + coins[index], dp);
        }

        int notpick = changeHelper(amount, coins, index + 1, currentSum, dp);

        return dp[index][currentSum] = pick + notpick;

    }

}
