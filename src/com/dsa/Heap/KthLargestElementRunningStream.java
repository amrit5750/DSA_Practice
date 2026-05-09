package com.dsa.Heap;

import java.util.PriorityQueue;

public class KthLargestElementRunningStream {

}

class KthLargest {

    PriorityQueue<Integer> queue;
    int k;

    public KthLargest(int k, int[] nums) {

        this.k = k;
        this.queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }

        }

    }

    public int add(int val) {
        queue.add(val);
        if (queue.size() > k) {
            queue.poll();
        }

        return queue.peek();

    }
}
