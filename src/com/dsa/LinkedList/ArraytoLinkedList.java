package com.dsa.LinkedList;

public class ArraytoLinkedList {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 4, 3, 2, 2 };
        Node head = convertAll2LL(arr);
        Node temp = head;
        int c = 0;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
            c++;
        }
        System.out.println("length is " + c);

        // System.out.println(head.data);

    }

    public static Node convertAll2LL(int[] nums) {

        Node head = new Node(nums[0]);
        Node mover = head;

        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static boolean isElementPresent(Node head, int num) {

        Node temp = head;

        while (temp != null) {
            if (temp.data == num) {
                return true;
            }
            temp = temp.next;
        }

        return false;
    }

}

class Node {

    int data;
    Node next;

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    Node(int data) {
        this.data = data;
        this.next = null;
    }

}
