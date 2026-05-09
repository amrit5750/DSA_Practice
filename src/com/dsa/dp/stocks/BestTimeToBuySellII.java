package com.dsa.dp.stocks;

public class BestTimeToBuySellII {

    public static void main(String[] args) {

        int[] prices = { 2, 1, 4, 5, 2, 9, 7 };
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        Integer[][][] dp = new Integer[prices.length + 1][3][3];
        return maxProfitHelper(prices, 0, 1, dp, 2);

    }

    public static int maxProfitHelper(int[] prices, int index, int buy, Integer[][][] dp, int transactions) {
        if (index >= prices.length) {
            return 0;
        }

        if (transactions == 0) {
            return 0;
        }

        if (dp[index][buy][transactions] != null) {
            return dp[index][buy][transactions];
        }
        int profit = 0;

        if (buy == 1) {
            int takeElement = -prices[index] + maxProfitHelper(prices, index + 1, 0, dp, transactions);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 1, dp, transactions);
            profit = Math.max(takeElement, notTakeElment);
        } else {
            int takeElement = prices[index] + maxProfitHelper(prices, index + 1, 1, dp, transactions - 1);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 0, dp, transactions);
            profit = Math.max(takeElement, notTakeElment);

        }

        return dp[index][buy][transactions] = profit;

    }

}
