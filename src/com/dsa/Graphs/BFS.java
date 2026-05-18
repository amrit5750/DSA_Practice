package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFS {

    public static void main(String[] args) {

        int nodes = 5, edges[][] = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 2, 4 } };
        int startingNode = 0;
        System.out.println(bfsOfGraph(nodes, edges, startingNode));

    }

    public static List<Integer> bfsOfGraph(int V, int[][] edges, int start) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < edges.length; i++) {
            if (map.containsKey(edges[i][0])) {
                map.get(edges[i][0]).add(edges[i][1]);
            } else {
                map.put(edges[i][0], new ArrayList<>());
                map.get(edges[i][0]).add(edges[i][1]);
            }
        }

        boolean[] visited = new boolean[V + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        List<Integer> resut = new ArrayList<>();
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            resut.add(currentNode);
            if (map.containsKey(currentNode)) {
                List<Integer> adj = map.get(currentNode);
                for (Integer adjELe : adj) {
                    if (visited[adjELe] == false) {
                        visited[adjELe] = true;
                        queue.add(adjELe);
                    }

                }
            }

        }

        return resut;

    }
}
