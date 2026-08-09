package com.dsa.dailyDigest;

import java.util.HashSet;
import java.util.Set;

public class MinExtraChar {

    public static void main(String[] args) {

        String s = "leetscode";
        String[] dictionary = { "leet", "code", "leetcode" };
        System.out.println(minExtraChar(s, dictionary));

    }

    static int[] t = new int[51];

    public static int solve(int i, String s, Set<String> st, int n) {
        if (i >= n) {
            return 0;
        }

        if (t[i] != -1) {
            return t[i];
        }

        int result = 1 + solve(i + 1, s, st, n); // skipping the ith character

        for (int j = i; j < n; j++) {
            String curr = s.substring(i, j + 1);
            if (st.contains(curr)) {
                // valid substring
                result = Math.min(result, solve(j + 1, s, st, n));
            }
        }

        return t[i] = result;
    }

    public static int minExtraChar(String s, String[] dict) {
        int n = s.length();
        Set<String> set = new HashSet<>();
        for (String string : dict) {
            set.add(string);

        }

        return solve(0, s, set, n);
    }

}
