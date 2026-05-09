package com.dsa.dp.Strings;

public class WildCardMatching {
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

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (p.charAt(j) == '*') {

            boolean emptyMatch = isMatchHelper(s, p, i, j + 1, dp);
            boolean consumeChar = i < s.length() && isMatchHelper(s, p, i + 1, j, dp);
            return dp[i][j] = emptyMatch || consumeChar;
        }

        boolean isFirstCharMatched = (i < s.length() &&
                (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'));

        return dp[i][j] = isFirstCharMatched && isMatchHelper(s, p, i + 1, j + 1, dp);

    }

}
