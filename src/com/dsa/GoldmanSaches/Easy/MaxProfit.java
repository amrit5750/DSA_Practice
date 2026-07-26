package com.dsa.GoldmanSaches.Easy;

public class MaxProfit {
    public static void main(String[] args) {

        // Input: prices = [7,1,5,3,6,4]
        // Output: 5
        // Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
        // 6-1 = 5.
        // Note that buying on day 2 and selling on day 1 is not allowed because you
        // must buy before you sell.
        int[] prices = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices));

    }

    public static int maxProfit(int[] prices) {

        int profit = Integer.MIN_VALUE;
        int minValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            minValue = Math.min(minValue, prices[i]);
            profit = Math.max(profit, prices[i] - minValue);

        }

        return profit < 0 ? 0 : profit;

    }

}
