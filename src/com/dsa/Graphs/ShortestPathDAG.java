package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.Stack;

public class ShortestPathDAG {

    public static void main(String[] args) {

        int N = 4;
        int M = 2;
        int[][] edge = { { 0, 1, 2 }, { 0, 2, 1 } };

        System.out.println(Arrays.toString(
                getShortestDistance(edge, N, M)));

    }

    public static void getTopo(Map<Integer, List<Adjacent>> map, int[] visited, Stack<Integer> stack, int node) {

        visited[node] = 1;
        for (Adjacent neighbours : map.get(node)) {
            int neighbour = neighbours.neighbour;

            if (visited[neighbour] == -1) {
                getTopo(map, visited, stack, neighbour);
            }
        }
        stack.add(node);

    }

    public static int[] getShortestDistance(int[][] edges, int nodes, int M) {

        Map<Integer, List<Adjacent>> map = new HashMap<>();

        for (int i = 0; i < nodes; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] is : edges) {
            int u = is[0];
            int v = is[1];
            int weight = is[2];
            map.get(u).add(new Adjacent(v, weight));
        }

        // getTopo sort
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[nodes];
        Arrays.fill(visited, -1);
        for (int i = 0; i < nodes; i++) {
            if (visited[i] == -1) {
                getTopo(map, visited, stack, i);
            }

        }
        int[] shortDistace = new int[nodes];

        Arrays.fill(shortDistace, Integer.MAX_VALUE);
        shortDistace[0] = 0;

        while (!stack.isEmpty()) {

            int node = stack.pop();

            for (Adjacent adj : map.get(node)) {

                int neighbour = adj.neighbour;
                int weight = adj.weight;

                if (shortDistace[node] != Integer.MAX_VALUE && shortDistace[node] + weight < shortDistace[neighbour]) {
                    shortDistace[neighbour] = shortDistace[node] + weight;
                }
            }

        }

        return shortDistace;

    }

}

class Adjacent {
    int neighbour;
    int weight;

    Adjacent(int neighbour, int weight) {
        this.neighbour = neighbour;
        this.weight = weight;

    }
}
