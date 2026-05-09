package com.dsa.LinkedList.Medium;

public class PlusoneToLL {

    public static void main(String[] args) {

        int[] arr = { 4, 5, 4 };

        ListNode head = convertAllToLL(arr);
        ListNode newListHead = Plusone(head);
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

    public static ListNode Plusone(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode reverseKList = reverse(head);

        ListNode temp = reverseKList;
        int carry = 1;

        while (temp != null) {
            temp.val = temp.val + carry;

            if (temp.val < 10) {
                carry = 0;
                break;
            } else {
                temp.val = 0;
                carry = 1;
            }
            temp = temp.next;
        }

        if (carry == 1) {
            ListNode newNode = new ListNode(1);
            ListNode newHNode = reverse(reverseKList);
            newNode.next = newHNode;
            return newNode;
        } else {
            ListNode newHNode = reverse(reverseKList);
            return newHNode;
        }

    }

    public static ListNode reverse(ListNode heaListNode) {

        ListNode prev = null;
        ListNode temp = heaListNode;

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
