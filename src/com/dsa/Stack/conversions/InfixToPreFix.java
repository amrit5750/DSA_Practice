package com.dsa.Stack.conversions;

import java.util.Stack;

//Reverse the Infix;
//Infix to postFix;
//reverse the ans;
// time complexity is O(n) and space complexity is O(n);

public class InfixToPreFix {

    public static void main(String[] args) {

        String s = "x+y*z/w+u";

        System.out.println(infixToPreFixconversion(s));
    }

    public static int priority(char ch) {

        if (ch == '^') {
            return 3;
        }
        if (ch == '*' || ch == '/') {
            return 2;
        }
        if (ch == '+' || ch == '-') {
            return 1;
        } else {
            return -1;
        }

    }

    public static String reverse(String s) {

        StringBuilder res = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ')') {
                res.append('(');
            } else if (s.charAt(i) == '(') {
                res.append(')');
            } else {
                res.append(s.charAt(i));
            }

        }
        return res.toString();

    }

    public static String infixToPostFixconversion(String s) {

        String ans = "";
        int i = 0;

        Stack<Character> stack = new Stack<>();

        while (i < s.length()) {
            char ch = s.charAt(i);

            if ((ch >= 'A' && ch <= 'Z') ||
                    (ch >= 'a' && ch <= 'z') ||
                    (ch >= '0' && ch <= '9')) {
                ans += ch;
            }

            else if (ch == '(') {
                stack.push(ch);
            }

            else if (ch == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    ans += stack.pop();
                }
                stack.pop();
            }

            else {
                if (s.charAt(i) == '^') {
                    while (!stack.isEmpty() && priority(ch) <= priority(stack.peek())) {
                        ans += stack.pop();
                    }
                } else {
                    while (!stack.isEmpty() && priority(ch) < priority(stack.peek())) {
                        ans += stack.pop();
                    }
                }
                stack.push(ch);
            }
            i++;
        }

        while (!stack.isEmpty()) {
            ans += stack.pop();
        }

        return ans;

    }

    public static String infixToPreFixconversion(String s) {

        String reverse = reverse(s);

        return reverse(infixToPostFixconversion(reverse));

    }

}
