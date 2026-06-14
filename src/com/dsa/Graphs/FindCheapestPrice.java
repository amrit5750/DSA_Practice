package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FindCheapestPrice {
    public static void main(String[] args) {

        int n = 4;
        int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 2, 0, 100 }, { 1, 3, 600 }, { 2, 3, 200 } };
        int src = 0;
        int dst = 3;
        int k = 1;

        System.out.println(findCheapestPrice(n, flights, src, dst, k));

    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }
        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);

        for (int[] is : flights) {
            int u = is[0];
            int v = is[1];
            int cost = is[2];
            map.get(u).add(new Pair(v, cost));
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(src, 0));
        int steps = 0;
        while (!queue.isEmpty() && steps <= k) {

            int N = queue.size();
            while (N != 0) {
                N--;
                Pair current = queue.poll();
                int cost = current.cost;
                int u = current.v;

                for (Pair pair : map.get(u)) {
                    int v = pair.v;
                    int new_cost = pair.cost;
                    if (distance[v] > cost + new_cost) {
                        distance[v] = cost + new_cost;
                        queue.add(new Pair(v, new_cost + cost));
                    }
                }

            }
            steps++;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];

    }

}

class Pair {
    int v;
    int cost;

    public Pair(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }

}
