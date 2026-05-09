package com.dsa.LinkedList.Medium;

public class LinkedListCycletwo {

    public static void main(String[] args) {

        int[] arr = { 3, 2, 0, -4 };
        ListNode head = convertAllToLL(arr);
        ListNode res = detectCycle(head);
        System.out.println(res.val);
    }

    public static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = head;

        Boolean isCycleDetected = false;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                isCycleDetected = true;
                break;
            }
            temp = temp.next;
        }

        if (!isCycleDetected) {
            return null;
        } else {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;

            }
            return slow;
        }

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
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}