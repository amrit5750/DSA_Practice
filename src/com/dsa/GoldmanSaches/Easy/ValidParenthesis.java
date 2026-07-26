package com.dsa.GoldmanSaches.Easy;

import java.util.Stack;

public class ValidParenthesis {

    public static void main(String[] args) {

        String s = "(]";
        System.out.println(isValid(s));

    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            if (!stack.isEmpty()) {

                if ((stack.peek() == '[' && s.charAt(i) == ']') ||
                        (stack.peek() == '{' && s.charAt(i) == '}') ||
                        (stack.peek() == '(' && s.charAt(i) == ')')) {
                    stack.pop();

                } else {
                    stack.add(s.charAt(i));
                }

            } else {
                stack.add(s.charAt(i));
            }
        }

        return stack.isEmpty() ? true : false;
    }
}
