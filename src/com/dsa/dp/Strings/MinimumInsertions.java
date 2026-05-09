package com.dsa.dp.Strings;

public class MinimumInsertions {

    public static void main(String[] args) {
        String s = "mbadm";
        System.out.println(minInsertions(s));

    }

    public static int minInsertions(String s) {
        Integer[][] dp = new Integer[s.length() + 1][s.length() + 1];
        return minInsertionsHelper(s, 0, s.length() - 1, dp);

    }

    public static int minInsertionsHelper(String s, int i, int j, Integer[][] dp) {

        if (i >= j) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }
        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = minInsertionsHelper(s, i + 1, j - 1, dp);
        } else {
            return dp[i][j] = 1 + Math.min(minInsertionsHelper(s, i + 1, j, dp), minInsertionsHelper(s, i, j - 1, dp));
        }
    }

}
