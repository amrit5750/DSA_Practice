package com.dsa.LinkedList;

public class TraversalInLinkedList {

    public static void main(String[] args) {

        int[] arr = { 12, 43, 2, 2, 4 };

        Node head = ConverAlltoLL(arr);
        System.out.println(head.data);

    }

    public static Node ConverAlltoLL(int[] arr) {

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;

        }

        return head;

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
