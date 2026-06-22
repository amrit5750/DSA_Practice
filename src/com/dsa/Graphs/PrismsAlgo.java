package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class PrismsAlgo {
    public static void main(String[] args) {

        int[][] graph = { { 0, 2, 1 }, { 0, 1, 2 }, { 2, 1, 1 }, { 2, 4, 2 }, { 2, 3, 2 }, { 4, 3, 1 } };
        int nodes = 5;
        System.out.println(getMinimumSpanningTree(graph, nodes));

    }

    public static int getMinimumSpanningTree(int[][] graph, int nodes) {

        int sum = 0;
        int[] visited = new int[nodes];
        Arrays.fill(visited, 0);
        Map<Integer, List<Edge>> adj = new HashMap<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>((a1, b1) -> a1.weight - b1.weight);

        for (int i = 0; i < nodes; i++) {
            adj.put(i, new ArrayList<>());
        }

        for (int[] edge : graph) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            adj.get(u).add(new Edge(v, weight));
            adj.get(v).add(new Edge(u, weight));
        }

        queue.add(new Edge(0, 0));

        while (!queue.isEmpty()) {
            Edge currEdge = queue.poll();
            int weight = currEdge.weight;
            int u = currEdge.node;

            if (visited[u] == 1) {
                continue;

            }
            visited[u] = 1;
            sum += weight;

            for (Edge edge : adj.get(u)) {
                if (visited[edge.node] != 1) {
                    queue.add(edge);
                }
            }
        }

        return sum;

    }

}

class Edge {
    int node;
    int weight;

    Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;

    }
}
