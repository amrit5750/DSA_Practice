package com.dsa.Heap;

import java.util.Arrays;
import java.util.HashMap;

import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequencyElement {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));

    }

    public static int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {

            int value = entry.getKey();
            int freq = entry.getValue();

            queue.add(new Pair(value, freq));

            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] res = new int[k];
        int i = 0;

        while (!queue.isEmpty()) {
            res[i] = queue.poll().key;
            i++;
        }

        return res;

    }

    static class Pair implements Comparable<Pair> {

        int key;
        int value;

        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return this.value - o.value;
        }
    }

}
