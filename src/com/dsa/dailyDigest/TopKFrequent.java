package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class TopKFrequent {

    public static void main(String[] args) {

    }

    public static int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((a1, b1) -> Integer.compare(a1.a, b1.b));
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            queue.add(new Pair(entry.getKey(), entry.getValue()));

            if (queue.size() > k) {
                queue.poll();
            }

        }

        int[] ans = new int[queue.size()];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i] = queue.poll().a;
            i++;

        }
        return ans;

    }

}

class Pair {

    int a;
    int b;

    public Pair(int a, int b) {
        this.a = a;
        this.b = b;
    }

}
