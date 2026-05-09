package com.dsa.Stack;

public class ImplementStackUsingLL {

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.top();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        System.out.println(stack.top());
        System.out.println(stack.size());
    }

}

class Stack {

    int size = 0;
    ListNode head = null;
    ListNode mover = null;

    public int size() {
        return size;
    }

    public void push(int x) {

        ListNode node = new ListNode(x);
        node.next = head;
        head = node;
        size++;

    }

    public void pop() {

        if (head == null) {
            throw new RuntimeException("Stack is Empty");
        }

        head = head.next;
        size--;
    }

    public int top() {

        if (head == null) {
            throw new RuntimeException("Stack is Empty");
        }
        return head.val;

    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
    }

}
