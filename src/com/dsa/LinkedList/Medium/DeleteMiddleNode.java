package com.dsa.LinkedList.Medium;

public class DeleteMiddleNode {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 4 };

        ListNode head = convertAllToLL(arr);
        ListNode newListHead = Delete(head);
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

    public static ListNode Delete(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        int len = getLen(head);
        int mid = (len / 2);

        ListNode temp = head;
        int counter = 0;
        while (temp != null) {
            counter++;
            if (counter == mid) {
                temp.next = temp.next.next;
                break;

            }
            temp = temp.next;
        }
        return head;
    }

    public static ListNode DeleteOptimal(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;

        }

        prev.next = slow.next;
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
