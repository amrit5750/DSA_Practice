package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TopologicalSortDFS {

    public static void main(String[] args) {
        int nodes = 6;
        int[][] edges = { { 0, 3 }, { 3, 1 }, { 1, 4 }, { 5, 4 }, { 2, 1 }, { 5, 1 }, { 2, 3 }, { 0, 2 } };

        System.out.println(ToplologicalSort(nodes, edges));

    }

    public static List<Integer> ToplologicalSort(int nodes, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nodes; i++) {
            map.put(i, new ArrayList<>());

        }

        for (int[] is : edges) {
            map.get(is[0]).add(is[1]);
        }

        boolean[] visited = new boolean[nodes];

        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) {
                DFSHelper(map, stack, visited, i);
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());

        }

        return result;

    }

    public static void DFSHelper(Map<Integer, List<Integer>> map, Stack<Integer> stack, boolean[] visited, int node) {

        visited[node] = true;

        for (int neighbour : map.get(node)) {
            if (!visited[neighbour]) {
                DFSHelper(map, stack, visited, neighbour);
            }
        }
        stack.add(node);
    }

}
