package com.dsa.dp.stocks;

public class BestTimeToBuySellI {

    public static void main(String[] args) {

        int[] prices = { 7, 1, 5, 3, 6, 4 };
        System.out.println(maxProfitOptimal(prices));

    }

    public static int maxProfitOptimal(int[] prices) {
        Integer[][] dp = new Integer[prices.length + 1][3];
        return maxProfitHelper(prices, 0, 1, dp);
    }

    public static int maxProfit(int[] prices) {

        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }

    public static int maxProfitHelper(int[] prices, int index, int buy, Integer[][] dp) {

        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][buy] != null) {
            return dp[index][buy];
        }
        int profit = 0;

        if (buy == 1) {
            int takeElement = -prices[index] + maxProfitHelper(prices, index + 1, 0, dp);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 1, dp);
            profit = Math.max(takeElement, notTakeElment);
        } else {
            int takeElement = prices[index] + maxProfitHelper(prices, index + 1, 1, dp);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 0, dp);
            profit = Math.max(takeElement, notTakeElment);

        }

        return dp[index][buy] = profit;
    }

}
