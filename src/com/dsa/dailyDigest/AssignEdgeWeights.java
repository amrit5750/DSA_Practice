package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AssignEdgeWeights {

    public static final int M = 1000000007;

    public static void main(String[] args) {
        int[][] edges = { { 1, 2 } };
        System.out.println(assignEdgeWeights(edges));

    }

    public static int getDepth(Map<Integer, List<Integer>> map, int root, int parent) {

        int depth = 0;

        for (Integer neighbour : map.get(root)) {
            if (neighbour == parent) {
                continue;
            }
            depth = Math.max(depth, getDepth(map, neighbour, root) + 1);

        }
        return depth;
    }

    public static int assignEdgeWeights(int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] is : edges) {
            map.computeIfAbsent(is[0], k -> new ArrayList<>()).add(is[1]);
            map.computeIfAbsent(is[1], k -> new ArrayList<>()).add(is[0]);
        }

        long depth = getDepth(map, 1, -1);

        return (int) getpower(2, depth - 1);

    }

    public static long getpower(long base, long exp) {

        if (exp == 0) {
            return 1;
        }

        long half = getpower(base, exp / 2);
        long result = (half * half) % M;

        if (exp % 2 == 1) {
            result = (result * base) % M;
        }

        return result;

    }

}
