package com.dsa.dailyDigest;

import java.util.Arrays;

public class MinimumCost {

    public static void main(String[] args) {

        int[] cost = { 6, 5, 7, 9, 2, 2 };
        System.out.println(minimumCost(cost));

    }

    public static int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int minCost = 0;
        for (int i = cost.length - 1; i >= 0; i--) {

            minCost += cost[i];
            i--;
            if (i >= 0) {
                minCost += cost[i];
            }
            i--;
        }

        return minCost;

    }

}
