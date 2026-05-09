package com.dsa.arrays.medium;

//time complexity : O(n)
//space complexity : O(1)
//how it works?
// It keeps track of the minimum price encountered so far
// It calculates the potential profit at each price point by subtracting the minimum price from the current price
// It updates the maximum profit whenever a higher profit is found  
public class BestTimeToBuySell {

    public static void main(String[] args) {

        int arr[] = { 7, 1, 5, 3, 6, 4 };

        System.out.println(maxProfit(arr));

    }

    public static int maxProfit(int Prices[]) {

        int maxProfit = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < Prices.length; i++) {
            minValue = Math.min(minValue, Prices[i]);
            maxProfit = Math.max(maxProfit, Prices[i] - minValue);
        }

        return maxProfit;

    }

}
