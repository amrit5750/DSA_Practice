package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IsBipartite {
    public static void main(String[] args) {
        int[][] graph = { { 1, 2, 3 }, { 0, 2 }, { 0, 1, 3 }, { 0, 2 } };
        System.out.println(isBipartite(graph));

    }

    public static boolean isBipartite(int[][] graph) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        int[] colors = new int[graph.length];
        Arrays.fill(colors, -1);

        for (int i = 0; i < graph.length; i++) {
            List<Integer> ls = new ArrayList<>();
            for (int adj : graph[i]) {
                ls.add(adj);
            }
            map.put(i, ls);
        }

        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == -1) {
                if (!dfs(map, colors, i, 0)) {
                    return false;
                }
            }
        }
        return true;

    }

    public static boolean dfs(Map<Integer, List<Integer>> map, int[] colors, int node, int currentColor) {

        colors[node] = currentColor;

        for (int neighbour : map.get(node)) {
            if (colors[neighbour] == colors[node]) {
                return false;
            }
            if (colors[neighbour] == -1) {
                colors[neighbour] = 1 - colors[node];
                if (!dfs(map, colors, neighbour, colors[neighbour])) {
                    return false;
                }
            }
        }
        return true;
    }

}
