package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.List;

public class EventualSafeNodes {
    public static void main(String[] args) {

        int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };

        System.out.println(eventualSafeNodes(graph));

    }

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        // 0 = unvisited
        // 1 = visiting
        // 2 = safe
        int[] state = new int[n];

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(graph, state, i)) {
                result.add(i);
            }
        }

        return result;
    }

    public static boolean dfs(int[][] graph, int[] state, int node) {

        // already processed
        if (state[node] != 0) {
            return state[node] == 2;
        }

        // mark as visiting
        state[node] = 1;

        for (int neighbour : graph[node]) {

            // cycle found
            if (state[neighbour] == 1) {
                return false;
            }

            // neighbour is unsafe
            if (!dfs(graph, state, neighbour)) {
                return false;
            }
        }

        // mark as safe
        state[node] = 2;

        return true;
    }

}
