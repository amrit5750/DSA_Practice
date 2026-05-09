package com.dsa.dp.MCM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinCostToCutStick {

    public static void main(String[] args) {

        int n = 7;
        int[] cuts = { 1, 3, 4, 5 };
        System.out.println(minCost(n, cuts));

    }

    public static int minCost(int n, int[] cuts) {

        Arrays.sort(cuts);
        List<Integer> cutList = new ArrayList<>();
        cutList.add(0);
        for (Integer ele : cuts) {
            cutList.add(ele);
        }
        cutList.add(n);
        Integer[][] dp = new Integer[cutList.size() + 1][cutList.size() + 1];
        return minCostHelper(0, cutList.size() - 1, cutList, dp);

    }

    public static int minCostHelper(int l, int r, List<Integer> cuts, Integer[][] dp) {

        if (r - l < 2) {
            return 0;
        }

        if (dp[l][r] != null) {
            return dp[l][r];
        }

        int result = Integer.MAX_VALUE;
        for (int i = l + 1; i <= r - 1; i++) {

            int cost = (cuts.get(r) - cuts.get(l)) + minCostHelper(l, i, cuts, dp) + minCostHelper(i, r, cuts, dp);
            dp[l][r] = result = Math.min(result, cost);

        }

        return result;

    }

}
