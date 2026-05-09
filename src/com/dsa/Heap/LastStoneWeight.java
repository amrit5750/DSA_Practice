package com.dsa.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {

        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(lastStoneWeight(stones));

    }

    public static int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (Integer stone : stones) {
            maxHeap.add(stone);
        }

        while (maxHeap.size() > 1) {

            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();

            if (max1 != max2) {
                maxHeap.add(max1 - max2);
            }

        }

        return maxHeap.isEmpty() ? 0 : maxHeap.poll();

    }

}
