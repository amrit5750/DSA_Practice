package com.dsa.dailyDigest;

import java.util.Arrays;

public class SumAndMultiplyTwo {

    static final int MOD = 1000000007;

    public static void main(String[] args) {

        String s = "10203004";
        int[][] queries = { { 0, 7 }, { 1, 3 }, { 4, 6 } };
        System.out.println(Arrays.toString(sumAndMultiply(s, queries)));

    }

    public static int[] sumAndMultiply(String s, int[][] queries) {

        int[] ans = new int[queries.length];

        for (int k = 0; k < queries.length; k++) {
            int l = queries[k][0];
            int r = queries[k][1];

            long number = 0;
            int digitSum = 0;

            for (int i = l; i <= r; i++) {
                char c = s.charAt(i);

                if (c != '0') {
                    int d = c - '0';
                    digitSum += d;
                    number = (number * 10 + d) % MOD;
                }
            }

            ans[k] = (int) ((digitSum * number) % MOD);
        }

        return ans;

    }

}
