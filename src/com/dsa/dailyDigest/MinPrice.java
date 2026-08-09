package com.dsa.dailyDigest;

import java.util.Arrays;

public class MinPrice {

    public static void main(String[] args) {
        int[] prices = { 100, 70 };
        int[] discounts = { 10, 40, 50 };
        System.out.println(minPrice(prices, discounts));

    }

    public static double minPrice(int[] prices, int[] discounts) {

        Arrays.sort(prices);
        Arrays.sort(discounts);

        int i = prices.length - 1;
        int j = discounts.length - 1;
        double finalPrice = 0;
        while (i >= 0 && j >= 0) {
            finalPrice += (prices[i] * (100 - discounts[j])) / 100;
            i--;
            j--;
        }

        if (i >= 0) {
            finalPrice += prices[i];
            i--;
        }
        return finalPrice;

    }

}
