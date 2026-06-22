package com.dsa.dailyDigest;

public class DeleteMiddleNode {

    public static void main(String[] args) {

        // head = [1,3,4,7,1,2,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(6);

        deleteMiddle(head);
        Print(head);

    }

    public static ListNode deleteMiddle(ListNode head) {

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

    public static void Print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;

        }
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
