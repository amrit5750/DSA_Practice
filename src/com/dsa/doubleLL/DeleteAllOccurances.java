package com.dsa.doubleLL;

public class DeleteAllOccurances {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 1, 4 };
        ListNode head = converAllToDll(arr);

        print(deleteAllOccurances(head, 1));

    }

    public static ListNode deleteAllOccurances(ListNode head, int k) {

        ListNode current = head;
        while (current != null) {

            if (current.val == k) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else {
                    current.prev.next = current.next;
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    }

                }
            }

            current = current.next;
        }

        return head;

    }

    public static ListNode converAllToDll(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;

        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

}

class ListNode {

    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;

    }

    ListNode(int val) {
        this.val = val;

    }

}