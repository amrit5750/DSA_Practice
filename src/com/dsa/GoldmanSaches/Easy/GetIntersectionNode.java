package com.dsa.GoldmanSaches.Easy;

public class GetIntersectionNode {
    public static void main(String[] args) {

    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode collissionNode = null;
        int lenA = getlen(headA);
        int lenB = getlen(headB);

        if ((lenA < lenB)) {
            collissionNode = getCollioListNode(headA, headB, lenB - lenA);

        } else {
            collissionNode = getCollioListNode(headB, headA, lenA - lenB);

        }
        return collissionNode;

    }

    public static ListNode getCollioListNode(ListNode headA, ListNode headB, int diff) {

        while (diff != 0) {
            headB = headB.next;
            diff--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    public static int getlen(ListNode head) {
        int counter = 0;
        while (head != null) {
            counter++;
            head = head.next;

        }
        return counter;
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
