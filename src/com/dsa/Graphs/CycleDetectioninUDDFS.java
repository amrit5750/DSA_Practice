package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CycleDetectioninUDDFS {
    public static void main(String[] args) {

        int nodes = 5, edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 } };

        System.out.println(dfsOfGraph(nodes, edges));

    }

    public static boolean dfsOfGraph(int nodes, int[][] edges) {

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
            if (!visited[i]) {
                if (dfsOfGraphHelper(adj, i, visited, -1)) {
                    return true;
                }
            }

        }

        return false;

    }

    public static boolean dfsOfGraphHelper(Map<Integer, List<Integer>> map, int u, boolean[] visited, int parent) {
        visited[u] = true;

        for (int neighbour : map.get(u)) {
            if (u == parent) {
                continue;
            }
            if (visited[neighbour] == true) {
                return true;
            }
            if (dfsOfGraphHelper(map, neighbour, visited, u)) {
                return true;
            }
        }

        return false;
    }

}
