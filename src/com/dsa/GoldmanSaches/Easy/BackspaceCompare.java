package com.dsa.GoldmanSaches.Easy;

import java.util.Stack;

public class BackspaceCompare {

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));

    }

    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '#') {
                stack.add(s.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        StringBuilder sRes = new StringBuilder();

        while (!stack.isEmpty()) {
            sRes.append(stack.pop());

        }

        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) != '#') {
                stack.add(t.charAt(i));
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
        }

        StringBuilder TRes = new StringBuilder();

        while (!stack.isEmpty()) {
            TRes.append(stack.pop());

        }

        return sRes.toString().equals(TRes.toString());
    }

}
