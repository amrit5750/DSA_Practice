package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WeightedSum {
    public static void main(String[] args) {

        int[] parent = { -1, 0, 0, 0, 2, 2 };
        int[] nums = { 5, 2, 3, 1, 4, 6 };
        System.out.println(weightedSum(parent, nums));

    }

    public static long weightedSum(int[] parent, int[] nums) {
        Map<Integer, List<Pair>> adj = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int i = 1; i < nums.length; i++) {
            adj.get(parent[i]).add(new Pair(i, nums[i]));
        }

        // get Depth :
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 1));
        long sum = 0;
        int maxDepth = 0;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int depth = current.value;
            maxDepth = Math.max(maxDepth, depth);

            for (Pair child : adj.get(node)) {
                queue.add(new Pair(child.node, depth + 1));

            }
        }

        queue.clear();

        queue.add(new Pair(0, 1));
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int node = current.node;
            int depth = current.value;

            sum += (long) nums[node] * (maxDepth - depth + 1);

            for (Pair pair : adj.get(node)) {
                queue.add(new Pair(pair.node, depth + 1));

            }

        }
        return sum;

    }

}

class Pair {
    int node;
    int value;

    Pair(int node, int value) {
        this.node = node;
        this.value = value;
    }
}