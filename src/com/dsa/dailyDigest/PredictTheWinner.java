package com.dsa.dailyDigest;

import java.util.Arrays;

public class PredictTheWinner {
    public static void main(String[] args) {

        int[] nums = { 1, 5, 2 };
        System.out.println(predictTheWinner(nums));
    }

    public static boolean predictTheWinner(int[] nums) {

        int sum = Arrays.stream(nums).sum();
        Integer[][] dp = new Integer[30][30];
        int res = predictTheWinnerHelper(0, nums.length - 1, nums, dp);

        return res >= sum - res ? true : false;

    }

    public static int predictTheWinnerHelper(int i, int j, int[] num, Integer[][] dp) {
        if (i > j)
            return 0;

        // Only one number left
        if (i == j)
            return num[i];

        // Two numbers left
        if (i + 1 == j)
            return Math.max(num[i], num[j]);

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        int take_i = num[i]
                + Math.min(predictTheWinnerHelper(i + 2, j, num, dp), predictTheWinnerHelper(i + 1, j - 1, num, dp));
        int take_j = num[j]
                + Math.min(predictTheWinnerHelper(i + 1, j - 1, num, dp), predictTheWinnerHelper(i, j - 2, num, dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }

}
