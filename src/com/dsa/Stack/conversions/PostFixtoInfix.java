package com.dsa.Stack.conversions;

import java.util.Stack;

//Time complexity is O(n) and space complexity is O(n);
public class PostFixtoInfix {

    public static void main(String[] args) {

        String s = "ab+c*";

        System.out.println(postToInfix(s));

    }

    public static String postToInfix(String s) {

        Stack<String> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            String ch = String.valueOf(s.charAt(i));
            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                stack.push(ch);
            }

            else {

                String secondElement = stack.pop();
                String firstelement = stack.pop();

                String newString = '(' + firstelement + ch + secondElement + ')';
                stack.push(newString);
            }

            i++;
        }

        return stack.peek();

    }

}
