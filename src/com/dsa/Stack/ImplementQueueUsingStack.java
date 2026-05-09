package com.dsa.Stack;

import java.util.Stack;

public class ImplementQueueUsingStack {

    public static void main(String[] args) {

        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());
        System.out.println(queue.pop());
        System.out.println(queue.empty());
    }

}

class MyQueue {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public MyQueue() {

    }

    public void push(int x) {
        input.add(x);

    }

    public int pop() {
        if (output.isEmpty()) {

            while (!input.isEmpty()) {
                output.push(input.pop());

            }
        }
        if (output.isEmpty()) {
            System.out.println("Queue is empty, cannot pop.");
            return -1;
        }

        return output.pop();

    }

    public int peek() {

        if (output.isEmpty()) {

            while (!input.isEmpty()) {
                output.push(input.pop());

            }
        }
        if (output.isEmpty()) {
            System.out.println("Queue is empty, cannot pop.");
            return -1;
        }

        return output.peek();

    }

    public boolean empty() {
        return input.isEmpty() && output.isEmpty();

    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
