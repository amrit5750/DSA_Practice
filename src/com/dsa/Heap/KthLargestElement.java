package com.dsa.Heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {

        int[] nums = { 3, 2, 1, 5, 6, 4 };

        int k = 2;

        System.out.println(findKthLargest(nums, k));

    }

    public static int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);

            if (queue.size() > k) {
                queue.poll();
            }
        }

        return queue.peek();

    }

}
