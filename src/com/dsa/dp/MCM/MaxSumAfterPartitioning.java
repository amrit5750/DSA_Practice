package com.dsa.dp.MCM;

public class MaxSumAfterPartitioning {

    public static void main(String[] args) {
        int[] arr = { 1, 15, 7, 9, 2, 5, 10 };
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));

    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp = new Integer[501];
        return maxSumAfterPartitioningHelper(arr, k, 0, dp);

    }

    public static int maxSumAfterPartitioningHelper(int[] arr, int k, int i, Integer[] dp) {
        if (i >= arr.length) {
            return 0;
        }

        if (dp[i] != null) {
            return dp[i];
        }

        int result = Integer.MIN_VALUE;
        int currentMax = -1;
        for (int j = i; j < arr.length && j - i + 1 <= k; j++) {
            currentMax = Math.max(currentMax, arr[j]);

            dp[i] = result = Math.max(result,
                    (j - i + 1) * currentMax + maxSumAfterPartitioningHelper(arr, k, j + 1, dp));

        }

        return result;
    }

}
