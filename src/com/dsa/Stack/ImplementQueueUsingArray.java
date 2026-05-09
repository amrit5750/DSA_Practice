package com.dsa.Stack;

public class ImplementQueueUsingArray {

    public static void main(String[] args) {

        Queue queue = new Queue();
        queue.size();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.pop();
        System.out.println(queue.top());
        System.out.println(queue.size());

    }

}

class Queue {

    private int[] arr = new int[100];
    private int start = -1;
    private int end = -1;
    int totalLen = 100;

    int size = 0;

    public int size() {
        return size;
    }

    public void push(int x) {

        if (size == 100) {
            throw new RuntimeException("Queue is Full");
        }

        if (size == 0) {
            start++;
            end++;
            arr[start] = x;

        } else {
            end = (end + 1) % totalLen;
            arr[end] = x;
        }
        size++;
    }

    public int top() {
        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        return arr[start];
    }

    public void pop() {
        if (size == 0) {
            throw new RuntimeException("Queue is Empty");
        }
        if (size == 1) {
            start = -1;
            end = -1;
        } else {
            start = (start + 1) % totalLen;
        }
        size--;
    }

}
