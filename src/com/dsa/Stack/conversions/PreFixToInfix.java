package com.dsa.Stack.conversions;

import java.util.Stack;

public class PreFixToInfix {

    public static void main(String[] args) {

        System.out.println(getPreFixToInfix("+ab"));

    }

    public static String getPreFixToInfix(String s) {

        Stack<String> stack = new Stack<>();

        int i = s.length() - 1;
        while (i >= 0) {
            String ch = String.valueOf(s.charAt(i));
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                stack.push(ch);
            }

            else {

                String firstelement = stack.pop();
                String secondElement = stack.pop();

                String newString = '(' + firstelement + ch + secondElement + ')';
                stack.push(newString);
            }

            i--;
        }

        return stack.peek();

    }

}
