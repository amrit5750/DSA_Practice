package com.dsa.dailyDigest;

public class DeleteDuplicates {

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(1);

        listNode.next.next = new ListNode(1);
        listNode.next.next.next = new ListNode(2);

        listNode.next.next.next.next = new ListNode(3);

        ListNode res = deleteDuplicates(listNode);
        print(res);

    }

    public static void print(ListNode hNode) {

        while (hNode != null) {

            System.out.print(hNode.val + " ");
            hNode = hNode.next;

        }

    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;

                }
                prev.next = head.next;

            } else {
                prev.next = head.next;

            }
            head = head.next;

        }
        return dummy.next;

    }

}

// Definition for singly-linked list.

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
