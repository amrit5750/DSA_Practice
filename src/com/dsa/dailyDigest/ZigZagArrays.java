package com.dsa.dailyDigest;

public class ZigZagArrays {

    int M = 1000000007;
    int l;
    int r;
    int n;

    public static void main(String[] args) {

    }

    public int zigZagArrays(int n, int l, int r) {
        this.l = l;
        this.r = r;
        this.n = n;

        long count = 0;
        Long[][][][] dp = new Long[n + 1][r - l + 2][r - l + 2][2];
        for (int i = l; i <= r; i++) {
            count = (count + helper(1, i, true, dp)) % M; // next greater
            count = (count + helper(1, i, false, dp)) % M; /// next Smaller

        }

        return (int) count;

    }

    public long helper(int index, int prev, boolean isNextGreater, Long[][][][] dp) {
        if (index == n - 1) {
            return isNextGreater ? r - prev : prev - l;
        }

        int k = isNextGreater ? 1 : 0;
        long count = 0;

        if (dp[index][prev - l][r - prev][k] != null)
            return dp[index][prev - l][r - prev][k];

        if (isNextGreater) {
            // Next element must be strictly greater than prev
            for (int i = prev + 1; i <= r; i++)
                count = (count + helper(index + 1, i, false, dp)) % M;
        } else {
            // Next element must be strictly smaller than prev
            for (int i = l; i < prev; i++)
                count = (count + helper(index + 1, i, true, dp)) % M;
        }

        return dp[index][prev - l][r - prev][k] = count;

    }
}
