package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GetArticulationPoint {
    public static void main(String[] args) {
        int V = 7;
        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(1, 2, 3));
        ls.add(Arrays.asList(0));
        ls.add(Arrays.asList(0, 3, 4, 5));
        ls.add(Arrays.asList(2, 0));
        ls.add(Arrays.asList(2, 6));
        ls.add(Arrays.asList(4, 5));

        System.out.println(articulationPoints(V, ls));

    }

    static int timer = 1;

    public static void dfs(int node, int parent,
            int[] tin, int[] low,
            int[] marked, int[] visited,
            List<List<Integer>> adj) {

        visited[node] = 1;
        tin[node] = low[node] = timer++;

        int child = 0;

        for (int neighbour : adj.get(node)) {

            if (neighbour == parent)
                continue;

            if (visited[neighbour] == 0) {

                dfs(neighbour, node, tin, low, marked, visited, adj);

                low[node] = Math.min(low[node], low[neighbour]);

                if (low[neighbour] >= tin[node] && parent != -1) {
                    marked[node] = 1;
                }

                child++;

            } else {
                low[node] = Math.min(low[node], tin[neighbour]);
            }
        }

        // Root articulation point
        if (parent == -1 && child > 1) {
            marked[node] = 1;
        }
    }

    public static List<Integer> articulationPoints(int n,
            List<List<Integer>> adj) {

        List<Integer> ls = new ArrayList<>();

        int[] visited = new int[n];
        int[] marked = new int[n];
        int[] tin = new int[n];
        int[] low = new int[n];

        for (int i = 0; i < low.length; i++) {
            if (visited[i] == 0) {
                dfs(i, -1, tin, low, marked, visited, adj);
            }

        }

        for (int i = 0; i < n; i++) {
            if (marked[i] == 1) {
                ls.add(i);
            }
        }

        if (ls.size() == 0) {
            ls.add(-1);
        }
        return ls;

    }

}
