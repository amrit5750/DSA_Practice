package com.dsa.Stack;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueue {

    public static void main(String[] args) {

        stack stack = new stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.size());

    }
}

class stack {

    Queue<Integer> mainQueue = new LinkedList<>();

    public int size() {
        return mainQueue.size();
    }

    public boolean isEmpty() {
        return mainQueue.size() == 0 ? true : false;
    }

    public int pop() {
        return mainQueue.remove();
    }

    public int top() {
        return mainQueue.peek();
    }

    public void push(int x) {
        mainQueue.add(x);
        for (int i = 0; i < mainQueue.size(); i++) {
            mainQueue.add(mainQueue.remove());
        }
    }

}
