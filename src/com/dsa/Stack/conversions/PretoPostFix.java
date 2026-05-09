package com.dsa.Stack.conversions;

import java.util.Stack;

public class PretoPostFix {

    public static void main(String[] args) {

        System.out.println(PreToPost("+ab"));

    }

    public static String PreToPost(String s) {

        Stack<String> stack = new Stack<>();

        int i = s.length() - 1;

        while (i >= 0) {

            String ch = String.valueOf(s.charAt(i));

            if ((s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ||
                    (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') ||
                    (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                stack.push(ch);
            } else {
                String ele1 = stack.pop();
                String ele2 = stack.pop();
                String newString = ele1 + ele2 + s.charAt(i);
                stack.push(newString);
            }
            i--;

        }

        return stack.pop();

    }

}
