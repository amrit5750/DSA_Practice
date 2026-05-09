package com.dsa.LinkedList.Insertion;

public class LinkedListInsertion {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 4, 3, 2, 2 };
        Node head = convertAll2LL(arr);

        // Node NewHeadList = AddElementToHead(head, 2);

        // Node NewTailList = AddElementToTail(NewHeadList, 2);
        // PrintList(NewHeadList);
        System.out.println(" ===============");
        // PrintList(NewTailList);

        Node newList = AddElementAtKthNode(head, 2, 434);
        PrintList(newList);

    }

    public static Node InsertBeforeValue(Node head, int value, int element) {

        Node insertedElement = new Node(element);
        Node temp = head;
        Node prev = null;

        if (head == null) {
            return head;
        }

        if (head.data == value) {
            insertedElement.next = head;
            return insertedElement;
        }

        while (temp != null) {
            if (temp.data == value) {
                prev.next = insertedElement;
                insertedElement.next = temp;
                break;
            }
            prev = temp;
            temp = temp.next;
        }

        return head;

    }

    public static Node AddElementAtKthNode(Node head, int k, int element) {

        Node insertedElement = new Node(element);

        if (head == null && k == 1) {
            return new Node(element);
        }
        if (k == 1) {
            insertedElement.next = head;
            return insertedElement;
        }

        int counter = 1;
        Node temp = head;
        Node prev = null;

        while (temp != null && counter < k) {
            counter++;
            prev = temp;
            temp = temp.next;

        }

        if (temp == null && counter < k) {
            System.out.println("Position k is out of bounds");
            return head; // Return unchanged list
        }
        prev.next = insertedElement;
        insertedElement.next = temp;

        return head;
    }

    public static Node AddElementToTail(Node head, int val) {
        Node lastElement = new Node(val);

        if (head == null) {
            return lastElement;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = lastElement;
        return head;

    }

    public static Node AddElementToHead(Node head, int val) {

        Node temp = new Node(val);
        temp.next = head;
        return temp;
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

    public static void PrintList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
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
