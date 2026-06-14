package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class CountPaths {

    static int M = 1000000009;

    public static void main(String[] args) {

        int n = 7;
        int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
                { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
        System.out.println(countPaths(n, roads));

    }

    public static int countPaths(int n, int[][] roads) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        Map<Integer, List<Pair>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];
            map.get(u).add(new Pair(weight, v));
            map.get(v).add(new Pair(weight, u));
        }

        long[] ans = new long[n];
        Arrays.fill(ans, Long.MAX_VALUE);
        queue.add(new Pair(0, 0));
        ans[0] = 0;
        int[] pathCount = new int[n];
        pathCount[0] = 1;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            long time = current.time;
            int node = current.v;

            if (time > ans[node])
                continue;

            for (Pair adj : map.get(node)) {

                int v = adj.v;
                long newtime = adj.time;

                if (time + newtime < ans[v]) {
                    ans[v] = time + newtime;
                    queue.add(new Pair(newtime + time, v));
                    pathCount[v] = pathCount[node];

                } else if (time + newtime == ans[v]) {
                    pathCount[v] = (pathCount[v] + pathCount[node]) % M;
                }

            }

        }

        return pathCount[n - 1];

    }
}

class Pair {
    long time;
    int v;

    public Pair(long time, int v) {
        this.time = time;
        this.v = v;
    }

}
