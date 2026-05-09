package com.dsa.dp.Strings;

public class Lcs {

    public static void main(String[] args) {

        String text1 = "bdefg";
        String text2 = "bfg";
        System.out.println(lcs(text1, text2));

    }

    public static int lcs(String text1, String text2) {
        Integer[][] dp = new Integer[text1.length() + 1][text2.length() + 1];
        return lcsHelper(text1, text2, 0, 0, dp);

    }

    public static int lcsHelper(String text1, String text2, int i, int j, Integer[][] dp) {

        if (i >= text1.length() || j == text2.length()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            return dp[i][j] = 1 + lcsHelper(text1, text2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(lcsHelper(text1, text2, i + 1, j, dp), lcsHelper(text1, text2, i, j + 1, dp));
        }
    }
}
