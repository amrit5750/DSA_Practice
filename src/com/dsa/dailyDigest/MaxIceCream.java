package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaxIceCream {
    public static void main(String[] args) {

        int[] costs = { 1, 6, 3, 1, 2, 5 };
        int coins = 20;
        System.out.println(maxIceCream(costs, coins));

    }

    public static int maxIceCream(int[] costs, int coins) {

        final int MAX_COST = 100000;
        int[] freq = new int[MAX_COST + 1];

        for (int i : costs) {
            freq[i]++;
        }
        int ans = 0;
        for (int cost = 1; cost < freq.length; cost++) {
            if (freq[cost] == 0) {
                continue;
            }
            int canBuy = Math.min(freq[cost], coins / cost);
            ans += canBuy;
            coins -= canBuy * cost;
        }
        return ans;
    }

}
