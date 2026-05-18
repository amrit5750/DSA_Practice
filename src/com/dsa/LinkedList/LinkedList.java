package com.dsa.LinkedList;

import java.util.Queue;

public class LinkedList implements Queue<Integer> {

    public static void main(String[] args) {

        int[] arr = { 1, 3, 4, 53, 23 };

        Node node = new Node(arr[0]);
        System.out.println(node.data);

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
