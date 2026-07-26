package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCompleteComponents {

    public static void main(String[] args) {

        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };

        System.out.println(countCompleteComponents(n, edges));

    }

    public static int countCompleteComponents(int n, int[][] edges) {
        int count = 0;
        Map<Integer, List<Integer>> map = new HashMap();

        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
            map.computeIfAbsent(edges[i][1], k -> new ArrayList<>()).add(edges[i][0]);
        }
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i] == true) {
                continue;
            }

            int[] info = new int[2];
            // info[0] = vertices
            // info[1] = degree sum

            dfs(i, map, visited, info);

            if (info[1] == info[0] * (info[0] - 1)) {
                count++;
            }

        }

        return count;

    }

    public static void dfs(int node, Map<Integer, List<Integer>> map, boolean[] visited, int[] info) {

        visited[node] = true;

        info[0]++;
        List<Integer> neighbours = map.getOrDefault(node, Collections.emptyList());

        info[1] += neighbours.size();

        for (int next : neighbours) {
            if (!visited[next]) {
                dfs(next, map, visited, info);
            }
        }
    }

}
