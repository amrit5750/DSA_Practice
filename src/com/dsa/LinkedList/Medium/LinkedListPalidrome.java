package com.dsa.LinkedList.Medium;

import java.util.Stack;

public class LinkedListPalidrome {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 2, 1 };
        ListNode head = convertAllToLL(arr);
        boolean res = isPalidrome(head);
        System.out.println(res);
    }

    public static boolean isPalidromeOptimal(ListNode head) {

        ListNode firsthalf = head;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHalf = reverse(slow);

        while (secondHalf != null) {
            if (firsthalf.val != secondHalf.val) {
                return false;
            }
            firsthalf = firsthalf.next;
            secondHalf = secondHalf.next;
        }

        return true;

    }

    public static ListNode reverse(ListNode head) {

        ListNode prev = null;

        while (head != null) {
            ListNode front = head.next;
            head.next = prev;
            prev = head;
            head = front;
        }
        return prev;
    }

    public static boolean isPalidrome(ListNode head) {

        Stack<Integer> stack = new Stack<>();

        ListNode temp = head;

        while (temp != null) {
            stack.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if (stack.peek() != temp.val) {
                return false;
            }
            stack.pop();
            temp = temp.next;
        }
        return true;
    }

    public static ListNode convertAllToLL(int[] arr) {

        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}