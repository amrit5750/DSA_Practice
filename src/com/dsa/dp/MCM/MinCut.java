package com.dsa.dp.MCM;

public class MinCut {

    public static void main(String[] args) {
        String s = "aab";
        System.out.println(minCut(s));

    }

    public static int minCut(String s) {
        Integer[][] dp = new Integer[2001][2001];
        return minCutHelper(s, 0, s.length() - 1, dp);

    }

    public static boolean isPalindrome(String s, int i, int j) {

        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;

        }
        return true;

    }

    public static int minCutHelper(String s, int i, int j, Integer[][] dp) {

        if (i >= j || isPalindrome(s, i, j))
            return 0;

        if (dp[i][j] != null)
            return dp[i][j];

        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            if (isPalindrome(s, i, k)) {
                if (dp[k + 1][j] == null)
                    dp[k + 1][j] = minCutHelper(s, k + 1, j, dp);
                min = Math.min(min, 1 + dp[k + 1][j]);
            }
        }
        return dp[i][j] = min;

    }

}
