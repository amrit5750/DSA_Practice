package com.dsa.dp.stocks;

public class BestTimeToBuySellVI {

    public static void main(String[] args) {

        int[] prices = { 1, 3, 2, 8, 4, 9 };
        System.out.println(maxProfit(prices, 2));

    }

    public static int maxProfit(int[] prices, int fee) {
        Integer[][] dp = new Integer[prices.length + 1][3];
        return maxProfitHelper(prices, 0, 1, dp, fee);

    }

    public static int maxProfitHelper(int[] prices, int index, int buy, Integer[][] dp, int fee) {
        if (index >= prices.length) {
            return 0;
        }

        if (dp[index][buy] != null) {
            return dp[index][buy];
        }
        int profit = 0;

        if (buy == 1) {
            int takeElement = -prices[index] + maxProfitHelper(prices, index + 1, 0, dp, fee);
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 1, dp, fee);
            profit = Math.max(takeElement, notTakeElment);
        } else {
            int takeElement = prices[index] + maxProfitHelper(prices, index + 1, 1, dp, fee) - fee;
            int notTakeElment = 0 + maxProfitHelper(prices, index + 1, 0, dp, fee);
            profit = Math.max(takeElement, notTakeElment);

        }

        return dp[index][buy] = profit;

    }

}
