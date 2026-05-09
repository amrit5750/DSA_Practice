package com.dsa.Stack;

public class ImplementStackUsingArray {

    public static void main(String[] args) {

        Stack stack = new Stack();
        stack.top();
        stack.push(1);
        stack.pop();
        stack.size();
    }

}

class Stack {

    private int index = -1;
    private int[] arr = new int[100];

    public int top() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");

        }
        return arr[index];
    }

    public void push(int x) {
        if (index == arr.length - 1) {
            throw new RuntimeException("Stack is Overflow");
        }

        arr[++index] = x;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return arr[index--];
    }

    public int size() {
        return index + 1;
    }

    public boolean isEmpty() {
        return index == -1;
    }

}
