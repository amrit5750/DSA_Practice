package com.dsa.LinkedList.Medium;

public class SortLinkedList {

    public static void main(String[] args) {

        int[] arr = { 4, 2, 1, 3 };

        ListNode head = convertAllToLL(arr);
        ListNode sorListNode = sortList(head);
        printList(sorListNode);

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

    public static ListNode getMiddle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode sortList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode middListNode = getMiddle(head);
        ListNode leftHead = head;
        ListNode RightHead = middListNode.next;
        middListNode.next = null;

        leftHead = sortList(leftHead);
        RightHead = sortList(RightHead);

        return mergeTwoLists(leftHead, RightHead);

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;

            } else {
                temp.next = list2;
                list2 = list2.next;

            }
            temp = temp.next;

        }
        if (list1 != null) {
            temp.next = list1;
        }

        if (list2 != null) {
            temp.next = list2;
        }

        return head.next;

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
