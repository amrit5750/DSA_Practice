package com.dsa.LinkedList.Easy;

public class MergetwoLists {

    public static void main(String[] args) {

        int[] arr1 = { 1, 2, 4, 2 };
        int[] arr2 = { 1, 3, 4 };

        ListNode list1 = insertAlltoLL(arr1);
        ListNode list2 = insertAlltoLL(arr2);

        ListNode headofMergedList = mergeTwoLists(list1, list2);

        // System.out.println(headofMergedList.val);

        getListLength(headofMergedList);

    }

    public static int getListLength(ListNode head) {

        int len = 0;
        ListNode temp = head;

        while (temp != null) {
            len++;
            System.out.println(temp.val);
            temp = temp.next;
        }
        return len;
    }

    public static ListNode insertAlltoLL(int[] nums) {

        ListNode head = new ListNode(nums[0]);
        ListNode mover = head;

        for (int i = 1; i < nums.length; i++) {
            ListNode temp = new ListNode(nums[i]);
            mover.next = temp;
            mover = temp;
        }

        return head;
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        if (list1 != null) {
            temp.next = list1;
            list1 = list1.next;
        } else {
            temp.next = list2;
            list2 = list2.next;
        }

        return head.next;
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
