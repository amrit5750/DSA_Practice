package com.dsa.Recursion.Easy;

import java.util.Stack;

public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);

        sortStack(stack);

        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {

        if (stack.isEmpty() || stack.size() == 1) {
            return stack;
        }

        int top = stack.pop();
        sortStack(stack);

        insertStack(stack, top);

        return stack;

    }

    public static void insertStack(Stack<Integer> stack, int element) {

        if (stack.isEmpty() || stack.peek() <= element) {
            stack.add(element);
            return;
        }

        int top = stack.pop();
        insertStack(stack, element);
        stack.add(top);
    }

}
