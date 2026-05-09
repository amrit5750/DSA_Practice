package com.dsa.LinkedList.hard;

public class ReverseGroupbyK {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5, 6 };

        ListNode head = converttoLL(arr);
        ListNode result = reversebyK(head, 2);
        print(result);

    }

    public static ListNode reversebyK(ListNode head, int k) {

        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode start = head;
        ListNode temp = head;
        int counter = 0;
        ListNode resHead = null;
        ListNode prevTail = null;

        while (temp != null) {
            counter++;
            if (counter == k) {
                ListNode next = temp.next;
                temp.next = null;
                ListNode revHead = reverseList(start);
                ListNode revTail = start;

                if (resHead == null) {
                    resHead = revHead;
                }

                if (prevTail != null) {
                    prevTail.next = revHead;
                }

                revTail.next = next;

                prevTail = revTail;
                start = next;
                temp = next;
                counter = 0;
            }

            else {
                temp = temp.next;
            }
        }

        if (prevTail != null) {
            prevTail.next = start;
        }

        return resHead;

    }

    public static ListNode converttoLL(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode mover = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i]);
            mover.next = temp;
            mover = temp;

        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;

        }
    }

    public static ListNode reverseList(ListNode head) {

        ListNode temp = head;
        ListNode prev = null;
        while (temp != null) {
            ListNode front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }

        return prev;
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
