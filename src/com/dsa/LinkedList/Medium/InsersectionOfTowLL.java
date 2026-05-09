package com.dsa.LinkedList.Medium;

public class InsersectionOfTowLL {

    public static void main(String[] args) {

        int[] ListA = { 1, 2, 0, 1, 0, 2 };
        int[] ListB = { 5, 6, 1, 8, 4, 5 };

        ListNode List1 = convertAllToLL(ListA);
        ListNode List2 = convertAllToLL(ListB);

        ListNode newListHead = getIntersectionNode(List1, List2);
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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode collListNode = null;

        int headALen = getLen(headA);
        int headBLen = getLen(headB);

        if (headALen < headBLen) {
            collListNode = getCollision(headA, headB, headBLen - headALen);
        } else {
            collListNode = getCollision(headB, headA, headALen - headBLen);
        }

        return collListNode;

    }

    public static ListNode getCollision(ListNode headA, ListNode headB, int d) {

        while (d != 0) {
            headB = headB.next;
            d--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA;

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
