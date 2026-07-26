package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinScore {

    static int ans;

    public static void main(String[] args) {

        int n = 4;
        int[][] roads = { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
        System.out.println(minScore(n, roads));

    }

    public static int minScore(int n, int[][] roads) {

        Map<Integer, List<List<Integer>>> map = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];
            map.computeIfAbsent(u, k -> new ArrayList<>()).add(Arrays.asList(v, cost));
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(Arrays.asList(u, cost));
        }
        boolean[] visited = new boolean[n + 1];
        ans = Integer.MAX_VALUE;
        dfs(1, map, n, visited);
        return ans;
    }

    public static void dfs(int node, Map<Integer, List<List<Integer>>> map, int n, boolean[] visited) {

        visited[node] = true;

        for (List<Integer> edge : map.getOrDefault(node, new ArrayList<>())) {
            int v = edge.get(0);
            int cost = edge.get(1);

            ans = Math.min(ans, cost);

            if (!visited[v]) {
                dfs(v, map, n, visited);
            }

        }

    }

}
