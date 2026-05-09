package com.dsa.dp.stocks;

public class BestTimeToBuySellIV {

    public static void main(String[] args) {

        int k = 2;
        int[] prices = { 2, 4, 1 };
        System.out.println(maxProfit(k, prices));

    }

    public static int maxProfit(int k, int[] prices) {
        Integer[][][] dp = new Integer[prices.length + 1][3][k + 1];
        return maxProfitHelper(prices, 0, 1, dp, k);

    }

    public static int maxProfitHelper(int[] prices, int index, int buy, Integer[][][] dp, int maxTransactions) {
        if (index >= prices.length) {
            return 0;
        }

        if (maxTransactions == 0) {
            return 0;
        }

        if (dp[index][buy][maxTransactions] != null) {
            return dp[index][buy][maxTransactions];
        }
        int profit = 0;

        if (buy == 1) {
            int takeElement = -prices[index] + maxProfitHelper(prices, index + 1, 0, dp, maxTransactions);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 1, dp, maxTransactions);
            profit = Math.max(takeElement, notTakeElment);
        } else {
            int takeElement = prices[index] + maxProfitHelper(prices, index + 1, 1, dp, maxTransactions - 1);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 0, dp, maxTransactions);
            profit = Math.max(takeElement, notTakeElment);

        }

        return dp[index][buy][maxTransactions] = profit;

    }

}
