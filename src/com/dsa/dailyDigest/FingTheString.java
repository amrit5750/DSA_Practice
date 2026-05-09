package com.dsa.dailyDigest;

import java.util.Arrays;

public class FingTheString {

    public static void main(String[] args) {

        int[][] lcp = { { 4, 0, 2, 0 }, { 0, 3, 0, 1 }, { 2, 0, 2, 0 }, { 0, 1, 0, 1 } };

        System.out.println(findTheString(lcp));

    }

    public static String findTheString(int[][] lcp) {

        char[] word = new char[lcp.length];
        Arrays.fill(word, '$');

        for (int i = 0; i < word.length; i++) {

            for (int j = 0; j < i; j++) {
                if (lcp[j][i] != 0) {
                    word[i] = word[j];
                    break;
                }

            }

            if (word[i] == '$') {
                boolean[] forBiddenChar = new boolean[26];
                Arrays.fill(forBiddenChar, false);

                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] == 0) {
                        forBiddenChar[word[j] - 'a'] = true;
                    }

                }

                // now iternate over forbidden
                for (int idx = 0; idx < 26; idx++) {
                    if (forBiddenChar[idx] == false) {
                        word[i] = (char) (idx + 'a');
                        break;
                    }

                }

                if (word[i] == '$') {
                    return "";
                }
            }

        }

        return Arrays.deepEquals(check(word), lcp) ? new String(word) : "";

    }

    public static int[][] check(char[] word) {

        int n = word.length;

        int[][] lcp = new int[n][n];
        for (int i = 0; i < lcp.length; i++) {
            lcp[i][n - 1] = (word[i] == word[n - 1]) ? 1 : 0;

        }
        for (int i = 0; i < lcp.length; i++) {
            lcp[n - 1][i] = (word[n - 1] == word[i]) ? 1 : 0;

        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (word[i] == word[j]) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }

            }

        }

        return lcp;

    }

}
