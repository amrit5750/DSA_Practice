package com.dsa.doubleLL;

import java.util.Set;
import java.util.TreeSet;

public class RemoveDuplicateFromSortedDLL {

    public static void main(String[] args) {

        int[] arr = { 1, 1, 3, 3, 4, 5 };
        ListNode head = converAllToDll(arr);
        print(removeDuplicates(head));

    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> sortedSet = new TreeSet<>();

        ListNode temp = head;

        while (temp != null) {
            sortedSet.add(temp.val);
            temp = temp.next;

        }

        ListNode uniqueList = new ListNode(-1);
        ListNode curListNode = uniqueList;

        for (Integer integer : sortedSet) {
            ListNode tNode = new ListNode(integer, null, curListNode);
            curListNode.next = tNode;
            curListNode = tNode;
        }
        uniqueList.next.prev = null;
        return uniqueList.next;

    }

    public static ListNode optimal(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;

                if (current.next != null) {
                    current.next.prev = current;

                }
            } else {
                current = current.next;
            }

        }

        return head;

    }

    public static ListNode converAllToDll(int[] arr) {
        ListNode head = new ListNode(arr[0]);
        ListNode prev = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode temp = new ListNode(arr[i], null, prev);
            prev.next = temp;
            prev = temp;

        }
        return head;
    }

    public static void print(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
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
