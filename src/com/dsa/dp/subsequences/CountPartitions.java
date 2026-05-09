package com.dsa.dp.subsequences;

import java.util.Arrays;

public class CountPartitions {

    public static int MOD = 1000000007;

    public static void main(String[] args) {
        int[] arr = { 5, 2, 6, 4 };
        int diff = 3;
        System.out.println(countPartitions(arr.length, diff, arr));

    }

    public static int countPartitions(int n, int diff, int[] arr) {

        int totalSum = Arrays.stream(arr).sum();
        Integer[][] dp = new Integer[arr.length + 1][totalSum + 1];
        return countPartitionsHelper(n, diff, arr, 0, 0, totalSum, dp);
    }

    public static int countPartitionsHelper(int n, int diff, int[] arr, int index, int currentSum, int totalSum,
            Integer[][] dp) {

        if (index == n) {
            int otherSum = totalSum - currentSum;

            if (currentSum >= otherSum && currentSum - otherSum == diff) {
                return 1;
            }
            return 0;
        }

        if (dp[index][currentSum] != null) {
            return dp[index][currentSum];

        }

        int take = countPartitionsHelper(n, diff, arr, index + 1, currentSum + arr[index], totalSum, dp);
        int noteTake = countPartitionsHelper(n, diff, arr, index + 1, currentSum, totalSum, dp);

        return dp[index][currentSum] = (take + noteTake) % MOD;

    }
}
