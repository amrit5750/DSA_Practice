package com.dsa.doubleLL;

public class insertion {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 2, 4 };

        ListNode head = converAllToDll(arr);
        ListNode newList = addBeforehead(head, 4);
        print(newList);

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

    public static ListNode addAtGivenNode(ListNode head, int k, int val) {

        ListNode newNode = new ListNode(val);

        if (head == null) {
            return newNode;
        }

        if (k == 1) {
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        ListNode temp = head;
        int counter = 0;

        while (temp != null && counter < k - 1) {
            temp = temp.next;
            counter++;

        }

        if (temp == null) {
            return head;
        }

        newNode.next = temp.next;
        newNode.prev = temp;

        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        return head;
    }

    public static ListNode addBeforehead(ListNode head, int k) {

        ListNode newNode = new ListNode(k);

        if (head == null) {
            return newNode;
        }

        newNode.prev = null;
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    public static ListNode addBeforetail(ListNode head, int k) {

        ListNode newNode = new ListNode(k);

        if (head == null) {
            return newNode;
        }

        if (head.next == null) {
            newNode.prev = null;
            newNode.next = head;
            head.prev = newNode;
            return newNode;
        }

        ListNode tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        newNode.prev = tail.prev;
        newNode.next = tail;

        tail.prev.next = newNode;
        tail.prev = newNode;

        return head;

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
