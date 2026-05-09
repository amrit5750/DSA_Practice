package com.dsa.dp.Strings;

public class MinDistance {
    public static void main(String[] args) {

        String word1 = "sea";
        String word2 = "eat";

        System.out.println(minDistance(word1, word2));

    }

    public static int minDistance(String word1, String word2) {

        Integer[][] dp = new Integer[word1.length() + 1][word2.length() + 1];
        return (word1.length() + word2.length()) - 2 * minDistanceHelper(word1, word2, 0, 0, dp);
    }

    public static int minDistanceHelper(String word1, String word2, int i, int j, Integer[][] dp) {

        if (i >= word1.length() || j >= word2.length()) {
            return 0;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = 1 + minDistanceHelper(word1, word2, i + 1, j + 1, dp);
        } else {
            return dp[i][j] = Math.max(minDistanceHelper(word1, word2, i + 1, j, dp),
                    minDistanceHelper(word1, word2, i, j + 1, dp));
        }

    }

}
