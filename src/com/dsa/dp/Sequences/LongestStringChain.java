package com.dsa.dp.Sequences;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestStringChain {
    public static void main(String[] args) {

        String[] words = { "a", "b", "ba", "bca", "bda", "bdca" };

        System.out.println(longestStrChain(words));

    }

    public static int longestStrChain(String[] words) {

        List<String> sortedList = Arrays.stream(words).sorted(Comparator.comparing(String::length)).toList();
        Integer[][] dp = new Integer[words.length + 1][words.length + 1];
        return longestStrChainHelper(sortedList, -1, 0, dp);

    }

    public static int longestStrChainHelper(List<String> sortedList, int prevIndex, int currentIndex, Integer[][] dp) {

        if (currentIndex == sortedList.size()) {
            return 0;
        }
        int take = 0;
        int notTake = 0;

        if (dp[prevIndex + 1][currentIndex] != null) {
            return dp[prevIndex + 1][currentIndex];
        }

        if (prevIndex == -1 || isPredecessor(sortedList.get(prevIndex), sortedList.get(currentIndex))) {
            take = 1 + longestStrChainHelper(sortedList, currentIndex, currentIndex + 1, dp);
        }
        notTake = longestStrChainHelper(sortedList, prevIndex, currentIndex + 1, dp);

        return dp[prevIndex + 1][currentIndex] = Math.max(take, notTake);

    }

    public static boolean isPredecessor(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if (m >= n || n - m != 1) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < word1.length() && j < word2.length()) {
            if (word1.charAt(i) == word2.charAt(j)) {
                i++;
            }
            j++;

        }

        return i == m;

    }
}
