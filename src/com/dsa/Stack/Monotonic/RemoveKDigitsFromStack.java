package com.dsa.Stack.Monotonic;

import java.util.Stack;

public class RemoveKDigitsFromStack {
    public static void main(String[] args) {

        System.out.println(removeKdigits("1432219", 3));

    }

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > num.charAt(i)) {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));
        }
        while (k > 0) {
            stack.pop();
            k--;
        }

        StringBuilder s = new StringBuilder();

        while (!stack.isEmpty()) {
            s.append(stack.pop());

        }
        s.reverse();

        int i = 0;
        while (i < s.length() - 1 && s.charAt(i) == '0') {
            i++;
        }

        return s.length() == 0 ? "0" : s.substring(i);

    }

}
