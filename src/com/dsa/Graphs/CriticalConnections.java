package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnections {
    public static void main(String[] args) {

        int n = 4;
        List<List<Integer>> connections = new ArrayList<>();
        connections.add(Arrays.asList(0, 1));
        connections.add(Arrays.asList(1, 2));
        connections.add(Arrays.asList(2, 0));

        connections.add(Arrays.asList(1, 3));

        System.out.println(criticalConnections(n, connections));

    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        List<List<Integer>> ans = new ArrayList<>();

        int[] visited = new int[n];
        int[] low = new int[n];
        int[] tin = new int[n];

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < tin.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (List<Integer> connection : connections) {
            int u = connection.get(0);
            int v = connection.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(0, -1, visited, adj, tin, low, ans);
        return ans;

    }

    static int timer = 1;

    public static void dfs(int node, int parent, int[] visited, List<List<Integer>> adj, int[] tin, int[] low,
            List<List<Integer>> ans) {

        visited[node] = 1;

        tin[node] = low[node] = timer;
        timer++;
        for (Integer neighbour : adj.get(node)) {
            if (neighbour == parent) {
                continue;
            }
            if (visited[neighbour] == 0) {
                dfs(neighbour, node, visited, adj, tin, low, ans);
                low[node] = Math.min(low[node], low[neighbour]);
                if (low[neighbour] > tin[node]) {
                    ans.add(Arrays.asList(neighbour, node));
                }

            } else {
                low[node] = Math.min(low[node], low[neighbour]);

            }
        }

    }

}
