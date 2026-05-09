package com.dsa.dp.Strings;

public class StringOneTwoStringTowConversion {
    public static void main(String[] args) {

        String word1 = "horse";
        String word2 = "ros";

        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {
        Integer[][] dp = new Integer[word1.length()][word2.length()];
        return minDistanceHelper(word1, word2, 0, 0, word1.length(), word2.length(), dp);
    }

    public static int minDistanceHelper(String word1, String word2, int i, int j, int m, int n, Integer[][] dp) {

        if (i == m) {
            return n - j;
        }
        if (j == n) {
            return m - i;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return minDistanceHelper(word1, word2, i + 1, j + 1, m, n, dp);
        }
        int insert = 1 + minDistanceHelper(word1, word2, i, j + 1, m, n, dp);
        int delete = 1 + minDistanceHelper(word1, word2, i + 1, j, m, n, dp);
        int relace = 1 + minDistanceHelper(word1, word2, i + 1, j + 1, m, n, dp);

        return dp[i][j] = Math.min(Math.min(insert, delete), relace);

    }

}
