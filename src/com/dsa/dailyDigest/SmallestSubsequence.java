package com.dsa.dailyDigest;

import java.util.Stack;

public class SmallestSubsequence {
    public static void main(String[] args) {
        String s = "bcabc";
        System.out.println(smallestSubsequence(s));

    }

    public static String smallestSubsequence(String s) {

        Stack<Character> stack = new Stack<>();

        boolean[] isTaken = new boolean[26];
        int[] lastIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastIndex[ch - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (isTaken[index] == true) {
                continue;
            }

            while (!stack.isEmpty() && stack.peek() > ch && lastIndex[stack.peek() - 'a'] > i) {
                isTaken[stack.peek() - 'a'] = false;
                stack.pop();

            }
            stack.add(ch);
            isTaken[index] = true;

        }
        return stack.stream()
                .map(String::valueOf)
                .collect(java.util.stream.Collectors.joining());

    }

}
