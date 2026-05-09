package com.dsa.Stack.Hard;

import java.util.HashMap;

class ListNode {

    int val;
    int key;
    ListNode next;
    ListNode prev;

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

}

public class LRUCache {

    int capacity;
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1, -1);
    HashMap<Integer, ListNode> map = new HashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        if (map.containsKey(key)) {
            ListNode res = map.get(key);
            int result = res.val;
            map.remove(key);
            delete(res);
            addAfterHead(res);
            map.put(key, head.next);
            return result;

        }
        return -1;

    }

    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode exListNode = map.get(key);
            map.remove(key);
            delete(exListNode);
        }

        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            delete(tail.prev);
        }

        addAfterHead(new ListNode(key, value));
        map.put(key, head.next);
    }

    public void addAfterHead(ListNode newListNode) {
        ListNode temp = head.next;
        newListNode.next = temp;
        newListNode.prev = head;
        head.next = newListNode;
        temp.prev = newListNode;
    }

    public void delete(ListNode delNode) {
        ListNode delPrev = delNode.prev;
        ListNode delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
    }

}
