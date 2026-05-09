package com.dsa.Recursion.Easy;

import java.util.Stack;

public class ReverseStack {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.add(3);
        stack.add(2);
        stack.add(1);

        System.out.println(getReversedStack(stack));

    }

    public static Stack<Integer> getReversedStack(Stack<Integer> stack) {

        if (stack.isEmpty() || stack.size() == 1) {
            return stack;
        }

        int top = stack.pop();
        getReversedStack(stack);

        // Stack<Integer> temp = new Stack<>();

        // while (!stack.isEmpty()) {
        // temp.push(stack.pop());

        // }

        // stack.push(top);
        // while (!temp.isEmpty()) {
        // stack.push(temp.pop());

        // }

        insertStack(stack, top);

        return stack;

    }

    public static void insertStack(Stack<Integer> stack, int element) {

        if (stack.isEmpty()) {
            stack.add(element);
            return;
        }
        int top = stack.pop();
        insertStack(stack, element);
        stack.add(top);
    }
}
