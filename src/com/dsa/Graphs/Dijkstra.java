package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkstra {

    public static void main(String[] args) {

        int[][] edges = { { 1, 2, 2 }, { 1, 1, 4 }, { 4, 3, 3 }, { 3, 1, 5 }, { 2, 4, 3 }, { 2, 5, 5 } };

        System.out.println(Arrays.toString(getShortPath(1, 5, edges, 5)));

    }

    public static int[] getShortPath(int startNode, int endNode, int[][] edges, int nodes) {

        Map<Integer, List<Adjacent>> map = new HashMap<>();
        int[] parent = new int[nodes + 1];
        for (int i = 1; i <= nodes; i++) {
            map.put(i, new ArrayList<>());
            parent[i] = i;
        }
        for (int[] is : edges) {
            int u = is[0];
            int weight = is[2];
            int v = is[1];

            map.get(u).add(new Adjacent(v, weight));
            map.get(v).add(new Adjacent(u, weight));
        }

        int[] distance = new int[nodes + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Adjacent> queue = new PriorityQueue<>();
        distance[startNode] = 0;
        queue.add(new Adjacent(startNode, 0));

        while (!queue.isEmpty()) {

            Adjacent currAdjacent = queue.poll();

            int node = currAdjacent.neighbour;
            int dis = currAdjacent.weight;

            if (dis > distance[node]) {
                continue;
            }

            for (Adjacent adj : map.get(node)) {

                int nextNode = adj.neighbour;
                int edgeWeight = adj.weight;

                if (distance[node] + edgeWeight < distance[nextNode]) {

                    distance[nextNode] = distance[node] + edgeWeight;
                    parent[nextNode] = node;

                    queue.offer(new Adjacent(nextNode, distance[nextNode]));
                }
            }

        }

        if (distance[endNode] == Integer.MAX_VALUE) {
            return new int[] {};
        }

        List<Integer> path = new ArrayList<>();

        int node = endNode;

        while (parent[node] != node) {
            path.add(node);
            node = parent[node];

        }
        path.add(startNode);
        Collections.reverse(path);

        return path.stream().mapToInt(Integer::intValue).toArray();

    }

}

class Adjacent implements Comparable<Adjacent> {
    int neighbour;
    int weight;

    Adjacent(int neighbour, int weight) {
        this.neighbour = neighbour;
        this.weight = weight;
    }

    @Override
    public int compareTo(Adjacent o) {
        return Integer.compare(this.weight, o.weight);
    }

}
