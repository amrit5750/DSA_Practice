package com.dsa.dp.MCM;

import java.util.ArrayList;
import java.util.List;

public class BurstBalloons {

    public static void main(String[] args) {

        int[] nums = { 3, 1, 5, 8 };
        System.out.println(maxCoins(nums));

    }

    public static int maxCoins(int[] nums) {

        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        for (int i = 0; i < nums.length; i++) {
            ls.add(nums[i]);

        }
        ls.add(1);
        Integer[][] dp = new Integer[101][101];
        return maxCoinsHelper(ls, 1, ls.size() - 2, dp);

    }

    public static int maxCoinsHelper(List<Integer> ls, int i, int j, Integer[][] dp) {

        if (i > j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int max = Integer.MIN_VALUE;

        for (int k = i; k <= j; k++) {
            int coins = ls.get(i - 1) * ls.get(k) * ls.get(j + 1) + maxCoinsHelper(ls, i, k - 1, dp)
                    + maxCoinsHelper(ls, k + 1, j, dp);

            dp[i][j] = max = Math.max(max, coins);
        }

        return max;

    }

}
