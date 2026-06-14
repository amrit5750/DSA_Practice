package com.dsa.dailyDigest;

public class MaxJumpsFive {
    public static void main(String[] args) {

        int[] arr = { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 };
        int d = 2;

        System.out.println(maxJumps(arr, d));

    }

    public static int maxJumps(int[] arr, int d) {

        int result = Integer.MIN_VALUE;
        Integer[] dp = new Integer[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            result = Math.max(result, maxJumpsHelper(arr, d, i, dp));
        }
        return result;

    }

    public static int maxJumpsHelper(int[] arr, int d, int index, Integer[] dp) {

        int result = 1;

        if (dp[index] != null) {
            return dp[index];
        }

        // left traversal ,i-1, i-2 ... i-d
        for (int j = index - 1; j >= Math.max(0, index - d); j--) {
            if (arr[j] >= arr[index]) {
                break;
            }
            result = Math.max(result, 1 + maxJumpsHelper(arr, d, j, dp));
        }

        // Right traversal ,i
        // i+1, i+2 ... i+d
        for (int j = index + 1; j <= Math.min(arr.length - 1, index + d); j++) {
            if (arr[j] >= arr[index]) {
                break;
            }
            result = Math.max(result, 1 + maxJumpsHelper(arr, d, j, dp));
        }

        return dp[index] = result;

    }

}
