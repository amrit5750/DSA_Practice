package com.dsa.dp.Strings;

import java.util.Map;

public class ShortestCommonSupersequence {

    public static void main(String[] args) {

        String str1 = "abac";
        String str2 = "cab";

        System.out.println(shortestCommonSupersequence(str1, str2));

    }

    public static String lcs(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int dp[][] = new int[m + 1][n + 1];
        // fill the dp array using dynamic programming
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        // backtrack from the bottom right corner of the dp array to find the LCS
        StringBuilder sb = new StringBuilder();
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                sb.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1])
                i--;
            else
                j--;
        }
        // reverse the LCS string and return it
        return sb.reverse().toString();
    }

    public static String shortestCommonSupersequence(String s1, String s2) {

        char lcs[] = lcs(s1, s2).toCharArray();
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        // merge s1 and s2 with the LCS
        for (char c : lcs) {
            // add characters from s1 until the LCS character is found
            while (s1.charAt(i) != c)
                sb.append(s1.charAt(i++));
            // add characters from s2 until the LCS character is found
            while (s2.charAt(j) != c)
                sb.append(s2.charAt(j++));
            // add the LCS character
            sb.append(c);
            i++;
            j++;
        }
        // add any remaining characters from s1 and s2
        sb.append(s1.substring(i)).append(s2.substring(j));
        // return the merged string
        return sb.toString();

    }

    public static String shortestCommonSupersequenceHelper(String str1, String str2, int i, int j,
            Map<String, String> dp) {

        if (i == str1.length()) {
            return str2.substring(j);
        }
        if (j == str2.length()) {
            return str1.substring(i);
        }

        String key = i + "|" + j;

        if (dp.containsKey(key)) {
            return dp.get(key);
        }

        if (str1.charAt(i) == str2.charAt(j)) {
            String res = str1.charAt(i) + shortestCommonSupersequenceHelper(str1, str2, i + 1, j + 1, dp);
            dp.put(key, res);
            return res;
        }

        String pickStr1 = str1.charAt(i) + shortestCommonSupersequenceHelper(str1,
                str2, i + 1, j, dp);
        String pickStr2 = str2.charAt(j) + shortestCommonSupersequenceHelper(str1,
                str2, i, j + 1, dp);

        String res = pickStr1.length() < pickStr2.length() ? pickStr1 : pickStr2;
        dp.put(key, res);
        return res;

    }

}
