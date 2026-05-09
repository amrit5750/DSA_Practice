package com.dsa.Recursion.Medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    public static void main(String[] args) {

        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(wordBreak(s, wordDict));

    }

    public static boolean isPresent(String s, Set<String> wordDict) {
        if (wordDict.contains(s)) {
            return true;
        }
        return false;
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordset = new HashSet<>(wordDict);
        Boolean[] memo = new Boolean[s.length()];

        return wordBreakHelper(s, wordset, 0, memo);
    }

    public static boolean wordBreakHelper(String s, Set<String> wordDict, int index, Boolean[] memo) {

        if (index == s.length()) {
            return true;
        }

        if (memo[index] != null) {
            return memo[index];
        }

        for (int i = index + 1; i <= s.length(); i++) {
            String temString = s.substring(index, i);
            if (isPresent(temString, wordDict) && wordBreakHelper(s, wordDict, i, memo)) {
                return memo[index] = true;
            }
        }
        return memo[index] = false;
    }

}
