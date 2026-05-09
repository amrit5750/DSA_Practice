package com.dsa.LinkedList.Medium;

public class AddTwoNumbers {

    public static void main(String[] args) {

        int[] list1 = { 2, 4, 3 };
        int[] list2 = { 5, 6, 4 };

        ListNode l1 = convertAllToLL(list1);
        ListNode l2 = convertAllToLL(list2);

        ListNode newListHead = addTwoNumbers(l1, l2);
        printList(newListHead);

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

    public static void printList(ListNode head) {

        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummyNode = new ListNode(-1);

        ListNode temp = dummyNode;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }

        return dummyNode.next;

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
