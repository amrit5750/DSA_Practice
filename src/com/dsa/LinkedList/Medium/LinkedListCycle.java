package com.dsa.LinkedList.Medium;

public class LinkedListCycle {

    public static void main(String[] args) {

        int[] arr = { 3, 2, 0, -4 };
        ListNode head = convertAllToLL(arr);
        boolean res = hasCycle(head);
        System.out.println(res);
    }

    public static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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