package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignEdgeWeightsTwo {

    public static final int M = 1000000007;

    public static void main(String[] args) {

        int[][] edges = { { 1, 2 } };
        int[][] queries = { { 1, 1 }, { 1, 2 } };

        System.out.println(Arrays.toString(assignEdgeWeights(edges, queries)));

    }

    public static long computePower(long base, long exp) {

        if (exp == 0) {
            return 1;
        }

        long half = computePower(base, exp / 2);
        long result = (half * half) % M;

        if (exp % 2 == 1) {
            result = (result * base) % M;
        }

        return result;
    }

    public static int getDepth(Map<Integer, List<Integer>> map, int root, int parent) {

        int depth = 0;

        for (int neighbour : map.get(root)) {
            if (neighbour == parent) {
                continue;
            }
            el depth = Math.max(depth, getDepth(map, neighbour, root) + 1);

        }

        return depth;

    }

    public static int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] edge : edges) {
            map.computeIfAbsent(edge[0], k -> new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k -> new ArrayList<>()).add(edge[0]);
        }

        long depth = getDepth(map, 1, -1);

        return (int) computePower(2, depth - 1);

    }

}
