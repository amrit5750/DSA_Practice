package com.dsa.Stack;

import java.util.NoSuchElementException;

public class ImplementQueueUsingLL {

    public static void main(String[] args) {

        Queue queue = new Queue();

        queue.push(1);
        queue.push(2);
        queue.push(3);

        queue.pop();

        System.out.println("Front element: " + queue.peek());
        System.out.println("Size: " + queue.size());
    }
}

class Queue {

    private int size = 0;
    private ListNode head = null;
    private ListNode tail = null;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Add element to rear of queue
    public void push(int x) {
        ListNode node = new ListNode(x);

        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.next = node; // link old tail to new node
            tail = node; // move tail forward
        }

        size++;
    }

    // Remove element from front of queue
    public void pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        head = head.next;
        size--;

        // If queue becomes empty, reset tail
        if (isEmpty()) {
            tail = null;
        }
    }

    // Return front element without removing
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }

        return head.val;
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}