package com.dsa.greedy.easy;

public class CoinChange {

    public static void main(String[] args) {

        int[] coins = { 186, 419, 83, 408 };
        int amount = 6249;

        System.out.println(coinChange(coins, amount));

    }

    public static int coinChange(int[] coins, int amount) {

        int n = coins.length;
        Integer dp[][] = new Integer[n][amount + 1];
        int ans = function(n - 1, amount, coins, dp);

        if (ans >= 1e9) {
            return -1;
        }
        return ans;
    }

    public static int function(int index, int target, int[] coins, Integer dp[][]) {

        if (index == 0) {
            if (target % coins[0] == 0) {
                return target / coins[0];
            }
            return (int) 1e9;
        }
        if (dp[index][target] != null) {
            return dp[index][target];
        }
        int take = Integer.MAX_VALUE;
        int noteTake = function(index - 1, target, coins, dp);

        if (coins[index] <= target) {
            take = 1 + function(index, target - coins[index], coins, dp);
        }

        dp[index][target] = Math.min(take, noteTake);
        return dp[index][target];
    }

}
