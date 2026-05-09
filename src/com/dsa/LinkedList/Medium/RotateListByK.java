package com.dsa.LinkedList.Medium;

public class RotateListByK {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4, 5 };

        ListNode head = convertAllToLL(arr);
        int k = 2;
        ListNode newListHead = rotateRight(head, k);
        printList(newListHead);

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

    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static int getLen(ListNode head) {
        int counter = 0;
        ListNode temp = head;

        while (temp != null) {
            counter++;
            temp = temp.next;

        }

        return counter;
    }

    public static ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int len = 1;

        ListNode tail = head;

        while (tail.next != null) {
            len++;
            tail = tail.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }

        tail.next = head;
        ListNode newTail = head;

        for (int i = 0; i < len - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;

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
