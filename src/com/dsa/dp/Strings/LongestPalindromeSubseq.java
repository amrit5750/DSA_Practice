package com.dsa.dp.Strings;

// | Complexity Type | Value     |
// | --------------- | --------- |
// | Time            | **O(n²)** |
// | Space           | **O(n²)** |

public class LongestPalindromeSubseq {

    public static void main(String[] args) {

        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));

    }

    public static int longestPalindromeSubseq(String s) {
        Integer[][] dp = new Integer[s.length() + 1][s.length() + 1];
        return longestPalindromeSubseqHelper(s, 0, s.length() - 1, dp);

    }

    public static int longestPalindromeSubseqHelper(String s, int i, int j, Integer[][] dp) {

        if (i > j) {
            return 0;
        }

        if (i == j) {
            return 1;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = 2 + longestPalindromeSubseqHelper(s, i + 1, j - 1, dp);
        } else {
            return dp[i][j] = Math.max(longestPalindromeSubseqHelper(s, i + 1, j, dp),
                    longestPalindromeSubseqHelper(s, i, j - 1, dp));
        }

    }

}