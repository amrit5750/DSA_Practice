package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class NetworkDelayTime {
    public static void main(String[] args) {

        int[][] times = { { 2, 1, 1 }, { 2, 3, 1 }, { 3, 4, 1 } };
        int n = 4;
        int k = 2;

        System.out.println(networkDelayTime(times, n, k));

    }

    public static int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i + 1, new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int weight = time[2];
            map.get(u).add(new Pair(weight, v));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        queue.add(new Pair(0, k));

        int[] ans = new int[n + 1];
        ans[k] = 0;
        Arrays.fill(ans, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int d = current.cost;
            int u = current.v;
            if (d > ans[u])
                continue; // ✅ skip outdated

            for (Pair neighbour : map.get(u)) {
                int adj = neighbour.v;
                int dist = neighbour.cost;

                if (d + dist < ans[adj]) {
                    ans[adj] = d + dist;
                    queue.add(new Pair(d + dist, adj));
                }

            }
        }

        int res = 0;
        for (int i = 1; i <= ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                return -1;
            }
            res = Math.max(res, ans[i]);

        }

        return res;

    }

}

class Pair {
    int cost;
    int v;

    public Pair(int cost, int v) {
        this.cost = cost;
        this.v = v;

    }

}
