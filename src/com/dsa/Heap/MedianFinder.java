package com.dsa.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    PriorityQueue<Integer> left_maxHeap;
    PriorityQueue<Integer> right_minHeap;

    Double medain;

    public MedianFinder() {
        this.left_maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        this.right_minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (left_maxHeap.isEmpty() || num <= left_maxHeap.peek()) {
            left_maxHeap.add(num);
        } else {
            right_minHeap.add(num);
        }

        if (left_maxHeap.size() - right_minHeap.size() > 1) {
            right_minHeap.add(left_maxHeap.poll());
        } else if (left_maxHeap.size() < right_minHeap.size()) {
            left_maxHeap.add(right_minHeap.poll());
        }

    }

    public double findMedian() {

        if (left_maxHeap.size() == right_minHeap.size()) {
            return (left_maxHeap.peek() + right_minHeap.peek()) / 2;
        } else {
            return left_maxHeap.peek();
        }

    }

}
