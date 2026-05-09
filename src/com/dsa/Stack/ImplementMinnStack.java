package com.dsa.Stack;

import java.util.Stack;

public class ImplementMinnStack {

    public static void main(String[] args) {

        MinStack obj = new MinStack();
        obj.push(2);
        obj.pop();

    }

}

class MinStack {

    Stack<Long> stack = new Stack<>();

    long min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int val) {
        long value = val;
        if (stack.isEmpty()) {
            min = val;
            stack.push(value);
        } else {
            if (min > val) {
                stack.push(2L * val - min);
                min = val;
            } else {
                stack.push(value);
            }

        }

    }

    public void pop() {
        if (stack.empty()) {
            throw new RuntimeException();
        }

        long top = stack.pop();
        if (top < min) {
            min = 2 * min - top;
        }
    }

    public int top() {
        if (stack.empty()) {
            throw new RuntimeException();
        }
        long top = stack.peek();

        if (top > min) {
            return (int) top;

        } else {
            return (int) min;
        }

    }

    public int getMin() {
        if (stack.empty()) {
            throw new RuntimeException();
        }
        return (int) min;

    }

}
