package com.dsa.LinkedList.Medium;

public class ReverseLinkedList {

    public static void main(String[] args) {

        int[] head = { 1, 2, 3, 4, 5 };

        ListNode list = converAllListNode(head);

        ListNode reverListNode = reverseList(list);
        System.out.println(reverListNode.val);

    }

    public static ListNode reverseList(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode temp = head;
        ListNode front = null;

        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;

    }

    public static ListNode converAllListNode(int[] arr) {

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

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
