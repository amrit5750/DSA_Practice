package com.dsa.dailyDigest;

public class CanReach {

    public static void main(String[] args) {

        int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;

        System.out.println(canReach(arr, start));

    }

    public static boolean canReach(int[] arr, int start) {

        Boolean[] dp = new Boolean[arr.length];
        return canReachHelper(arr, start, dp);
    }

    public static boolean canReachHelper(int[] arr, int start, Boolean[] dp) {

        if (start < 0 || start >= arr.length || arr[start] < 0) {
            return false;
        }

        if (dp[start] != null) {
            return dp[start];
        }

        if (arr[start] == 0) {
            return true;
        }

        arr[start] *= -1;

        boolean a = canReachHelper(arr, start + arr[start], dp);
        boolean b = canReachHelper(arr, start - arr[start], dp);

        return dp[start] = a || b;

    }

}
