package com.dsa.dp.Strings;

public class RegularExpressionMatching {

    public static void main(String[] args) {

        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p));

    }

    public static boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return isMatchHelper(s, p, 0, 0, dp);

    }

    public static boolean isMatchHelper(String s, String p, int i, int j, Boolean[][] dp) {

        if (j >= p.length()) {
            return i >= s.length();
        }

        boolean isFistCharMatched = false;

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            isFistCharMatched = true;
        }

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean notTake = isMatchHelper(s, p, i, j + 2, dp);
            boolean take = isFistCharMatched && isMatchHelper(s, p, i + 1, j, dp);
            return dp[i][j] = take || notTake;
        }
        return dp[i][j] = isFistCharMatched && isMatchHelper(s, p, i + 1, j + 1, dp);
    }

}
