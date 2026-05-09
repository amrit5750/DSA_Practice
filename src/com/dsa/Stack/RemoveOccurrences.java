package com.dsa.Stack;

import java.util.Stack;

public class RemoveOccurrences {

    public static void main(String[] args) {

        String s = "daabcbaabcbc";
        String part = "abc";
        System.out.println(removeOccurrences(s, part));

    }

    public static String removeOccurrencesOptimal(String s, String part) {

        while (s.contains(part)) {
            int index = s.indexOf(part);
            s = s.substring(0, index) + s.substring(index + part.length());
        }
        return s;

    }

    public static boolean isMatching(String part, Stack<Character> stack) {

        Stack<Character> stack2 = new Stack<>();
        stack2.addAll(stack);

        for (int i = part.length() - 1; i >= 0; i--) {
            if (stack2.peek() != part.charAt(i)) {
                return false;
            }
            stack2.pop();
        }
        return true;
    }

    public static String removeOccurrences(String s, String part) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
            if (stack.size() >= part.length() && isMatching(part, stack)) {
                for (int j = 0; j < part.length(); j++) {
                    stack.pop();
                }
            }
        }
        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }

}
