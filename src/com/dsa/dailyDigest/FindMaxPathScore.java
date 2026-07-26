package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FindMaxPathScore {

    public static void main(String[] args) {

        int[][] edges = { { 0, 1, 5 }, { 1, 3, 10 }, { 0, 2, 3 }, { 2, 3, 4 } };
        boolean[] online = { true, true, true, true };
        int k = 10;
        System.out.println(findMaxPathScore(edges, online, k));

    }

    public static boolean check(int mid, long k, Map<Integer, List<List<Integer>>> map, int n) {

        PriorityQueue<Pair> queue = new PriorityQueue<>((a, b) -> Long.compare(a.first, b.first));

        Long[] result = new Long[n];
        Arrays.fill(result, Long.MAX_VALUE);
        result[0] = 0L;

        queue.add(new Pair(0, 0));

        while (!queue.isEmpty()) {

            Pair current = queue.poll();
            if (current.first != result[current.second])
                continue;
            long first = current.first;
            int second = current.second;

            if (first > k) {
                return false;
            }

            if (second == n - 1) {
                return true;
            }

            List<List<Integer>> neighbours = map.get(second);

            if (neighbours == null)
                continue;

            for (List<Integer> neighbour : neighbours) {

                int neigh = neighbour.get(0);
                int neighCost = neighbour.get(1);

                if (neighCost < mid) {
                    continue;
                }

                if (first + neighCost < result[neigh]) {
                    result[neigh] = first + neighCost;
                    queue.add(new Pair(first + neighCost, neigh));
                }

            }

        }
        return false;

    }

    public static int findMaxPathScore(int[][] edges, boolean[] online, long k) {

        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int n = online.length;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            if (!online[u] || !online[v]) {
                continue;
            }
            map.computeIfAbsent(u, j -> new ArrayList<>()).add(Arrays.asList(v, cost));
            l = Math.min(l, cost);
            r = Math.max(r, cost);
        }

        int ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(mid, k, map, n)) {
                ans = mid;
                l = mid + 1;

            } else {
                r = mid - 1;
            }

        }
        return ans;

    }

    static class Pair {
        long first;
        int second;

        public Pair(long first, int second) {
            this.first = first;
            this.second = second;
        }

    }

}
