package com.dsa.dp.stocks;

public class BestTimeToBuySell {

    public static void main(String[] args) {

        int[] prices = { 7, 6, 4, 3, 1 };
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(min, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - min);

        }
        return maxProfit;

    }

}
