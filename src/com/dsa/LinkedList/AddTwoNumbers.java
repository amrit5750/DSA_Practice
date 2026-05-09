package com.dsa.LinkedList;

import java.util.Arrays;

public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        // l1.next.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = addTwoNumbers(l1, l2);
        print(result);
    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public static int getNumber(ListNode node) {
        StringBuilder str = new StringBuilder();
        while (node != null) {
            str.append(node.val);
            node = node.next;
        }

        return Integer.parseInt(str.toString());

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int num1 = getNumber(l1);
        int num2 = getNumber(l2);

        int result = num1 + num2;

        String[] res = String.valueOf(result).split("");
        System.out.println(Arrays.toString(res));

        ListNode head = new ListNode(-1);
        ListNode temp = head;
        for (int i = 0; i < res.length; i++) {
            temp.next = new ListNode(Integer.parseInt(res[i]));
            temp = temp.next;
        }

        return head.next;

    }

}

class ListNode {

    ListNode next;
    int val;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

}
