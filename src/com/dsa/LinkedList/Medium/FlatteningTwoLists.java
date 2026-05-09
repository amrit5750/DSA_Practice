package com.dsa.LinkedList.Medium;

// flattening a linked list with next and child pointer
//how it works is we will first flatten the list from the end and then merge it with the previous list and so on until we reach the head of the list
// we will use the merge function to merge two sorted linked list and return the head of the merged list
// the merge function will take two linked list as input and will return the head of the merged list
// the merge function will compare the values of the two linked list and will add the smaller value to the merged list and will move the pointer of the linked list which has the smaller value
// the merge function will continue until one of the linked list is null and then it will add
// the remaining linked list to the merged list and will return the head of the merged list
// the time complexity of this approach is O(n*m) where n is the number of nodes in the linked list and m is the number of nodes in the child linked list
// the space complexity of this approach is O(1) as we are not using any extra space for merging the linked list

public class FlatteningTwoLists {

    public static void main(String[] args) {

        ListNode head = new ListNode(5);
        head.child = new ListNode(14);

        head.next = new ListNode(10);
        head.next.child = new ListNode(4);

        head.next.next = new ListNode(12);
        head.next.next.child = new ListNode(20);
        head.next.next.child.child = new ListNode(13);

        head.next.next.next = new ListNode(7);
        head.next.next.next.child = new ListNode(17);

        print(flatteningList(head));

    }

    public static void print(ListNode head) {

        while (head != null) {
            System.out.print(head.val + " ");
            head = head.child;

        }
    }

    public static ListNode flatteningList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode mergedHead = flatteningList(head.next);

        head.next = null;
        return merged(head, mergedHead);

    }

    public static ListNode merged(ListNode list1, ListNode list2) {

        if (list1 == null) {
            return list2;
        }

        if (list2 == null) {
            return list1;
        }

        ListNode dummy = new ListNode(-1);

        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                current.child = list1;
                current = list1;
                list1 = list1.child;

            } else {
                current.child = list2;
                current = list2;
                list2 = list2.child;
            }

            current.next = null;

        }

        if (list1 != null) {
            current.child = list1;
        } else {
            current.child = list2;
        }

        return dummy.child;
    }

}

class ListNode {

    int val;
    ListNode next;
    ListNode child;

    ListNode(int val, ListNode next, ListNode child) {
        this.val = val;
        this.next = next;
        this.child = child;
    }

    ListNode(int val) {
        this.val = val;
    }

}