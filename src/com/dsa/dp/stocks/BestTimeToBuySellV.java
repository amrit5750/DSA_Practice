package com.dsa.dp.stocks;

public class BestTimeToBuySellV {

    public static void main(String[] args) {

        int[] prices = { 1, 2, 3, 0, 2 };
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {
        Integer[][] dp = new Integer[prices.length + 1][3];
        return maxProfitHelper(prices, 0, 1, dp);

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
            int takeElement = prices[index] + maxProfitHelper(prices, index + 2, 1, dp);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 0, dp);
            profit = Math.max(takeElement, notTakeElment);

        }

        return dp[index][buy] = profit;

    }

}
