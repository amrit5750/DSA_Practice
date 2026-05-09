package com.dsa.dp.subsequences;

public class CountSubsetsWithSumK {

    static int MOD = 1_000_000_007;

    public static void main(String[] args) {

        int[] arr = { 2, 3, 5, 16, 8, 10 };
        int K = 10;
        System.out.println(perfectSum(arr, K));

    }

    public static int perfectSum(int[] arr, int K) {

        Integer[][] dp = new Integer[K + 1][arr.length + 1];
        return perfectSumHelper(arr, K, 0, dp);

    }

    public static int perfectSumHelper(int[] arr, int target, int index, Integer[][] dp) {

        if (target == 0) {
            return 1;
        }
        if (index >= arr.length || target < 0) {
            return 0;
        }
        if (dp[target][index] != null) {
            return dp[target][index];
        }
        int take = perfectSumHelper(arr, target - arr[index], index + 1, dp);
        int notTake = perfectSumHelper(arr, target, index + 1, dp);

        return dp[target][index] = take + notTake;

    }

}
