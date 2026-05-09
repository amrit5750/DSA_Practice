package com.dsa.Stack.Hard;

import java.util.HashMap;
import java.util.Map;

class LFUCache {

    int maxsize;
    int minFrequency;
    int currentSize;
    private Map<Integer, Node> keyNode;
    private Map<Integer, DLList> freqListMap;

    LFUCache(int capacity) {
        maxsize = capacity;
        minFrequency = 0;
        currentSize = 0;
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
    }

    public void updateFrequency(Node node) {
        int freq = node.count;
        DLList list = freqListMap.get(freq);
        list.removeNode(node);

        if (freq == minFrequency && list.size == 0) {
            minFrequency++;
        }

        node.count++;

        DLList newList = freqListMap.getOrDefault(node.count, new DLList());
        newList.addFront(node);
        freqListMap.put(node.count, newList);
    }

    public int get(int key) {
        if (!keyNode.containsKey(key))
            return -1;

        Node node = keyNode.get(key);
        updateFrequency(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (maxsize == 0)
            return;

        if (keyNode.containsKey(key)) {
            Node node = keyNode.get(key);
            node.val = value;
            updateFrequency(node);
            return;
        }

        if (currentSize == maxsize) {
            DLList minFreqList = freqListMap.get(minFrequency);
            Node nodeToRemove = minFreqList.tail.prev;

            minFreqList.removeNode(nodeToRemove);
            keyNode.remove(nodeToRemove.key);
            currentSize--;
        }

        currentSize++;
        minFrequency = 1;

        Node newNode = new Node(key, value);
        DLList list = freqListMap.getOrDefault(1, new DLList());
        list.addFront(newNode);

        freqListMap.put(1, list);
        keyNode.put(key, newNode);
    }
}

class DLList {
    int size;
    Node head;
    Node tail;

    DLList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFront(Node node) {
        Node temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
        size++;
    }

    public void removeNode(Node delNode) {
        Node prevNode = delNode.prev;
        Node nextNode = delNode.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
        size--;
    }
}

class Node {
    int val;
    int key;
    int count;
    Node prev;
    Node next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        count = 1;
    }
}