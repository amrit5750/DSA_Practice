package com.dsa.LinkedList.Medium;

public class CopyRandomList {

    public static void main(String[] args) {

        Node head = new Node(7);
        head.next = new Node(14);
        head.next.next = new Node(21);
        head.next.next.next = new Node(28);

        head.random = head.next.next;
        head.next.random = head;
        head.next.next.random = head.next.next.next;
        head.next.next.next.random = head.next;

    }

    public Node copyRandomList(Node head) {

        Node temp = head;

        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;

        }

        temp = head;

        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;

            }

            temp = temp.next.next;
        }

        Node dummy = new Node(-1);
        Node copyTail = dummy;
        temp = head;

        while (temp != null) {

            Node copyNode = temp.next;

            // add copied node to new list
            copyTail.next = copyNode;
            copyTail = copyNode;

            // restore original list
            temp.next = copyNode.next;

            temp = temp.next;
        }

        return dummy.next;

    }

    public static Node convertAllToLL(int[] arr) {

        Node head = new Node(arr[0]);
        Node mover = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i]);
            mover.next = temp;
            mover = temp;
        }
        return head;
    }

    public static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
