package com.dsa.Heap;

import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static void main(String[] args) {

        ListNode[] ls = new ListNode[3];
        // [[1,4,5],[1,3,4],[2,6]]

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ls[0] = l1;

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ls[1] = l2;

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(4);
        l3.next.next = new ListNode(6);

        ls[2] = l3;

        ListNode result = mergeKLists(ls);

        print(result);

    }

    public static void print(ListNode hNode) {

        while (hNode != null) {
            System.out.print(hNode.val + " ");
            hNode = hNode.next;

        }
    }

    public static ListNode mergeKListsOptimal(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;

        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        ListNode dummyNode = new ListNode(-1);
        ListNode current = dummyNode;

        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            current.next = smallest;
            current = current.next;

            if (smallest.next != null) {
                queue.add(smallest.next);
            }
        }

        return dummyNode.next;
    }

    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeListHelper(lists, 0, lists.length - 1);
    }

    public static ListNode mergeListHelper(ListNode[] lists, int left, int right) {

        if (left == right) {
            return lists[left];
        }

        int mid = left + (right - left) / 2;
        ListNode l1 = mergeListHelper(lists, left, mid);
        ListNode l2 = mergeListHelper(lists, mid + 1, right);
        return mergeTowSortedLists(l1, l2);
    }

    public static ListNode mergeTowSortedLists(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(-1);
        ListNode temp = dummyNode;
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
        temp.next = (list1 != null) ? list1 : list2;

        return dummyNode.next;
    }

}

class ListNode {

    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
