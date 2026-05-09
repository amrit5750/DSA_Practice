package com.dsa;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheImplementation {

    static int capacity = 100;
    static Map<Integer, ListNode> map = new HashMap<>();

    static ListNode head = new ListNode(-1, -1);
    static ListNode tail = new ListNode(-1, -1);

    public LRUCacheImplementation(int capacity) {
        head.next = tail;
        tail.prev = head;
    }

    public static void addAfterHead(ListNode node) {
        ListNode temp = head.next;
        node.next = temp;
        node.prev = head;
        head.next = node;
        temp.prev = node;
    }

    public static void delete(ListNode delNode) {
        ListNode delPrev = delNode.prev;
        ListNode delNext = delNode.next;
        delPrev.next = delNext;
        delNext.prev = delPrev;
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

    public void put(int key, int val) {

        if (map.containsKey(key)) {
            ListNode exListNode = map.get(key);
            map.remove(key);
            delete(exListNode);
        }
        if (map.size() == capacity) {
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        addAfterHead(new ListNode(key, val));
        map.put(key, head.next);
    }

    public static void main(String[] args) {

    }

}

class ListNode {

    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val) {
        this.key = key;
        this.val = val;
    }

    ListNode(int val, ListNode next, ListNode prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }

}
