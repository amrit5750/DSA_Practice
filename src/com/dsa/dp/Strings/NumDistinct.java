package com.dsa.dp.Strings;

public class NumDistinct {

    public static void main(String[] args) {

        String s = "rabbbit";
        String t = "rabbit";

        System.out.println(numDistinct(s, t));

    }

    public static int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length() + 1][t.length() + 1];
        return numDistinctHelper(s, t, s.length() - 1, t.length() - 1, dp);

    }

    public static int numDistinctHelper(String s, String t, int i, int j, Integer[][] dp) {
        if (j < 0) {
            return 1;
        }
        if (i < 0) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            return dp[i][j] = numDistinctHelper(s, t, i - 1, j - 1, dp) + numDistinctHelper(s, t, i - 1, j, dp);
        }
        return dp[i][j] = numDistinctHelper(s, t, i - 1, j, dp);

    }
}