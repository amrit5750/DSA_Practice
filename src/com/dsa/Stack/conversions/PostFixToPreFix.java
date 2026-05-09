package com.dsa.Stack.conversions;

import java.util.Stack;

public class PostFixToPreFix {

    public static void main(String[] args) {

        System.out.println(PostToPre("ab+"));

    }

    public static String PostToPre(String s) {

        Stack<String> stack = new Stack<>();

        int i = 0;

        while (i < s.length()) {

            String ch = String.valueOf(s.charAt(i));

            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                stack.push(ch);
            } else {
                String ele1 = stack.pop();
                String ele2 = stack.pop();
                String newString = s.charAt(i) + ele2 + ele1;
                stack.push(newString);
            }
            i++;

        }

        return stack.pop();

    }

}
