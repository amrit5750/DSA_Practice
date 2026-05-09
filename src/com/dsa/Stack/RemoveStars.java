package com.dsa.Stack;

import java.util.Stack;

public class RemoveStars {

    public static void main(String[] args) {
        String s = "erase*****";
        System.out.println(removeStars(s));
    }

    public static String removeStars(String s) {

        char[] str = s.toCharArray();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length; i++) {

            if (!stack.isEmpty() && str[i] == '*') {
                stack.pop();
            } else {
                stack.push(str[i]);
            }
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();

    }

}
