package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TopologicalSortBFS {

    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = { { 0, 3 }, { 3, 1 }, { 1, 4 }, { 5, 4 }, { 2, 1 }, { 5, 1 }, { 2, 3 }, { 0, 2 } };

        System.out.println(ToplologicalSort(nodes, edges));

    }

    public static List<Integer> ToplologicalSort(int nodes, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            map.put(i, new ArrayList<>());

        }

        for (int[] is : edges) {
            map.get(is[0]).add(is[1]);
        }

        int[] indegree = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            for (int neighbour : map.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nodes; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }

        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {

            int current = queue.poll();
            List<Integer> neighbours = map.get(current);
            result.add(current);

            for (Integer neighbour : neighbours) {

                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }

        }

        return result;

    }

}
