package com.dsa.Stack.Easy;

import java.util.Stack;

public class ClearDigits {

    public static void main(String[] args) {

        String s = "cb34";

        System.out.println(clearDigits(s));

    }

    public static String clearDigits(String s) {

        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < charArray.length; i++) {

            if (Character.isDigit(charArray[i])) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(charArray[i]);
            }

        }

        StringBuilder str = new StringBuilder();
        while (!stack.isEmpty()) {
            str.append(stack.pop());

        }

        return str.reverse().toString();

    }

}
