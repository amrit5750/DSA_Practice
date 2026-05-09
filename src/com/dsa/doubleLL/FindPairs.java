package com.dsa.doubleLL;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.List;

public class FindPairs {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 4, 5, 6, 8, 9 };
        ListNode head = converAllToDll(arr);
        List<List<Integer>> list = getPairs(head, 7);

        for (List<Integer> list2 : list) {
            System.out.println(list2);
        }
    }

    public static List<List<Integer>> getPairs(ListNode head, int k) {

        ListNode left = head;
        ListNode tail = head;

        List<List<Integer>> result = new ArrayList<>();
        while (tail.next != null) {
            tail = tail.next;
        }

        ListNode right = tail;

        while (left != null && right != null && left != right && right.next != left) {
            int sum = left.val + right.val;

            if (sum == k) {
                result.add(Arrays.asList(left.val, right.val));
                left = left.next;
                right = right.prev;
            } else if (sum < k) {
                left = left.next;

            } else {
                right = right.prev;
            }
        }

        return result;

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