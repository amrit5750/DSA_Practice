package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFS {
    public static void main(String[] args) {

        int nodes = 5, edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 } };
        int startingNode = 0;
        List<Integer> ls = new ArrayList<>();

        dfsOfGraph(nodes, edges, startingNode, ls);
        System.out.println(ls);

    }

    public static void dfsOfGraph(int nodes, int[][] edges, int startingNode, List<Integer> ls) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            map.computeIfAbsent(edges[i][0], k -> new ArrayList<>()).add(edges[i][1]);
        }
        boolean[] visited = new boolean[nodes];
        dfsOfGraphHelper(map, startingNode, ls, visited);

    }

    public static void dfsOfGraphHelper(Map<Integer, List<Integer>> map, int startNode, List<Integer> ls,
            boolean[] visited) {

        visited[startNode] = true;

        ls.add(startNode);
        if (map.containsKey(startNode)) {
            for (Integer child : map.get(startNode)) {
                if (!visited[child]) {
                    dfsOfGraphHelper(map, child, ls, visited);
                }
            }
        }
    }
}
