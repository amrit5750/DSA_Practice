package com.dsa.Revision;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Map.Entry;

public class TopKFrequent {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            queue.add(new Pair(key, value));

            if ((queue.size() > k)) {
                queue.poll();
            }

        }

        int[] result = new int[k];
        int i = 0;

        while (queue.isEmpty()) {
            result[i] = queue.poll().key;
            i++;

        }
        return result;
    }

}

class Pair implements Comparable<Pair> {

    int key;
    int val;

    public Pair(int key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int compareTo(Pair o) {
        return this.val - o.val;
    }

}
