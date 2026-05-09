package com.dsa.doubleLL;

public class Deletion {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2, 4 };

        ListNode doubleLinkedList = converAllToDLL(arr);
        // ListNode doubleLinkedListDelHead = deleteHeadofDLL(doubleLinkedList);
        // ListNode doubleLLDelTail = deleteTailofDLL(doubleLinkedList);

        // printDLL(doubleLinkedList);
        ListNode newListNode = deletekthElement(doubleLinkedList, 1);
        // printDLL(doubleLinkedListDelHead);
        // printDLL(doubleLLDelTail);
        printDLL(newListNode);

    }

    public static ListNode deleteHeadofDLL(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode prev = head;

        head = head.next;
        head.prev = null;
        prev.next = null;

        return head;

    }

    public static ListNode deleteTailofDLL(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode prev = tail.prev;
        prev.next = null;
        tail.prev = null;

        return head;

    }

    public static ListNode deletekthElement(ListNode head, int k) {

        // If the list is empty, return null
        if (head == null) {
            return null;
        }

        // Traverse to the k-th element
        ListNode temp = head;
        int cnt = 1; // Start counting from 1 (since you want to delete the 1st, 2nd, etc.)

        // Handle if k is out of range
        while (temp != null && cnt < k) {
            cnt++;
            temp = temp.next;
        }

        // If the node to delete was not found (k is out of range)
        if (temp == null) {
            return head;
        }

        // If the node to delete is the head node
        if (temp == head) {
            head = temp.next;
            if (head != null) {
                head.prev = null;
            }
            return head;
        }

        // If the node to delete is the tail node
        if (temp.next == null) {
            temp.prev.next = null;
            return head;
        }

        // Deleting a node in the middle (not head or tail)
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

        return head;
    }

    public static ListNode converAllToDLL(int[] arr) {

        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;

        }

        return head;

    }

    public static void printDLL(ListNode list) {

        ListNode temp = list;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;

        }
    }

}

class ListNode {
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int val) {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    ListNode() {
    }

}
