package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.List;

public class PairSum {

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(pairSum(head));

    }

    public static int pairSum(ListNode head) {
        List<Integer> ls = new ArrayList<>();

        while (head != null) {
            ls.add(head.val);
            head = head.next;
        }
        System.out.println(ls);

        int max = Integer.MIN_VALUE;

        int left = 0;
        int right = ls.size() - 1;

        while (left < right) {
            max = Math.max(max, ls.get(right) + ls.get(left));
            left++;
            right--;

        }
        return max;

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
