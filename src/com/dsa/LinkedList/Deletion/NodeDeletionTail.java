package com.dsa.LinkedList.Deletion;

public class NodeDeletionTail {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 3, 42, 4, 2 };

        Node head = ConverAlltoLL(arr);

        Node newLL = deleteNodeTail(head);

        System.out.println(newLL.data);

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

    public static Node deleteNodeTail(Node head) {

        if (head == null || head.next == null) {
            return null;
        }

        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
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
