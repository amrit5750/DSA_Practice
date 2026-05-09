package com.dsa.doubleLL;

public class ReverseDLL {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2, 4 };

        ListNode doubleLinkedList = converAllToDll(arr);

        ListNode revDLL = revDLL(doubleLinkedList);
        // printDLL(doubleLinkedListDelHead);
        // printDLL(doubleLLDelTail);
        print(revDLL);

    }

    public static ListNode revDLL(ListNode head) {

        ListNode last = null;
        ListNode current = head;

        while (current != null) {

            last = current.prev;
            current.prev = current.next;
            current.next = last;

            current = current.prev;
        }

        return last.prev;

    }

    public static void print(ListNode hNode) {

        ListNode temp = hNode;
        while (temp != null) {
            {
                System.out.print(temp.val + " ");
                temp = temp.next;
            }
        }
    }

    public static ListNode converAllToDll(int arr[]) {

        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

}

class ListNode {

    int val;
    ListNode prev;
    ListNode next;

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;

    }

    ListNode(int val) {
        this.val = val;
    }
}
