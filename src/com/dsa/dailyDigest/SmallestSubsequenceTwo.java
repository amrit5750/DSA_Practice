package com.dsa.dailyDigest;

import java.util.Stack;

public class SmallestSubsequenceTwo {

    public static void main(String[] args) {
        String s = "bcbbc";
        System.out.println(smallestSubsequence(s));

    }

    public static String smallestSubsequence(String s) {

        Stack<Character> stack = new Stack<>();
        boolean[] isTaken = new boolean[26];
        int[] lastSeen = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            lastSeen[ch - 'a'] = i;
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            int index = ch - 'a';
            if (isTaken[index] == true) {
                continue;
            }
            while (!stack.isEmpty() && stack.peek() > ch && lastSeen[stack.peek() - 'a'] > i) {
                isTaken[stack.peek() - 'a'] = false;
                stack.pop();
            }

            stack.add(ch);
            isTaken[index] = true;
        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }

        return str.reverse().toString();

    }

}
