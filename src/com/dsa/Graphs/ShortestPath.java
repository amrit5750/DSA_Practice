package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPath {

    public static int[] shortestPath(int[][] edges, int N, int M) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] is : edges) {
            map.get(is[0]).add(is[1]);
            map.get(is[1]).add(is[0]);
        }

        int[] result = getShortestDistance(map, N, 0);
        return result;
    }

    public static int[] getShortestDistance(Map<Integer, List<Integer>> map, int nodes, int startNode) {

        int[] ans = new int[nodes];

        int distance = 0;
        Arrays.fill(ans, -1);
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(startNode, distance));
        ans[startNode] = distance;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            for (Integer neighbours : map.get(current.node)) {

                if (ans[neighbours] != -1) {
                    ans[neighbours] = current.Distance + 1;
                    queue.add(new Pair(neighbours, current.Distance + 1));
                }

            }

        }

        return ans;

    }

    public static void main(String[] args) {
        int N = 5;
        int M = 4;

        int[][] edges = {
                { 0, 1 },
                { 0, 2 },
                { 1, 3 },
                { 2, 4 }
        };

        System.out.println(Arrays.toString(shortestPath(edges, N, M)));

    }

}

class Pair {

    int node;
    int Distance;

    public Pair(int node, int distance) {
        this.node = node;
        Distance = distance;
    }
}
