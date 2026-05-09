package com.dsa.LinkedList.Deletion;

public class DeleteKthNode {

    public static void main(String[] args) {
        int[] arr = { 1, 3, 4, 3, 2, 2 };

        Node head = ConverAlltoLL(arr);

        deleteNthNode(head, 3);

    }

    public static Node deleteNthNode(Node head, int k) {

        Node temp = head;
        int counter = 0;
        Node previous = null;

        if (head == null) {
            return head;
        }

        if (k == 1) {
            return head.next;
        }

        while (temp != null) {
            counter++;
            if (counter == k) {
                previous.next = previous.next.next;
                break;
            }
            previous = temp;
            temp = temp.next;
        }

        return head;

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
