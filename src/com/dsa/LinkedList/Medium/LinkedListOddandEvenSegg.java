package com.dsa.LinkedList.Medium;

public class LinkedListOddandEvenSegg {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };
        ListNode head = convertAllToLL(arr);
        ListNode res = gListNode(head);
        System.out.println(res.val);
    }

    public static ListNode gListNode(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenIndexStart = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }

        odd.next = evenIndexStart;
        return head;

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