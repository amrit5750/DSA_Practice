package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class CycleDetectioninUDBFS {
    public static void main(String[] args) {

        int nodes = 5, edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 } };

        System.out.println(bfsOfGraph(nodes, edges));

    }

    public static boolean bfsOfGraph(int nodes, int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();
        for (int i = 0; i < nodes; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]); // Add both directions for undirected graph
        }
        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i] && bfsOfGraphHelper(adj, i, visited)) {
                return true;
            }
        }

        return false;

    }

    public static boolean bfsOfGraphHelper(Map<Integer, List<Integer>> map, int u, boolean[] visited) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(u, -1));
        visited[u] = true;
        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            int source = current.x;
            int parent = current.y;

            for (Integer neighbours : map.get(source)) {
                if (!visited[neighbours]) {
                    visited[neighbours] = true;
                    queue.add(new Pair(neighbours, source));

                } else if (parent != neighbours) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Pair {

    int x;
    int y;

    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
