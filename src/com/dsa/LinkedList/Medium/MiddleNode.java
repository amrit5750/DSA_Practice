package com.dsa.LinkedList.Medium;

public class MiddleNode {

    public ListNode middleNode(ListNode head) {
        int len = getLen(head);
        int start = (len / 2);

        for (int i = 0; i < start; i++) {
            head = head.next;
        }
        return head;

    }

    public static int getLen(ListNode head) {
        ListNode temp = head;
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }
        return counter;
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
