package com.dsa.LinkedList.Medium;

public class SortLinkedListZeroOneTwo {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 0, 1, 0, 2 };

        ListNode head = convertAllToLL(arr);
        ListNode newListHead = SortedList(head);
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

    public static ListNode SortedList(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode zeroDummy = new ListNode(-1);
        ListNode oneDummy = new ListNode(-1);
        ListNode twodummy = new ListNode(-1);

        ListNode zero = zeroDummy;
        ListNode one = oneDummy;
        ListNode two = twodummy;

        ListNode temp = head;

        while (temp != null) {
            if (temp.val == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.val == 1) {
                one.next = temp;
                one = one.next;
            } else {
                two.next = temp;
                two = two.next;

            }
            temp = temp.next;
        }

        zero.next = oneDummy.next != null ? oneDummy.next : twodummy.next;
        one.next = twodummy.next;
        return zeroDummy.next;

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
