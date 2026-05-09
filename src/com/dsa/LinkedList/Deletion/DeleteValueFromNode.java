package com.dsa.LinkedList.Deletion;

public class DeleteValueFromNode {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 42, 4, 2 };

        Node head = ConverAlltoLL(arr);

        Node newLL = deleteNValue(head, 42);

        System.out.println(newLL.data);

    }

    public static Node deleteNValue(Node head, int val) {

        if (head == null) {
            return head;
        }

        if (head.data == val) {
            return head.next;
        }

        Node temp = head;
        Node prev = null;

        while (temp.next != null) {

            if (temp.data == val) {
                prev.next = prev.next.next;
                break;
            }

            prev = temp;
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