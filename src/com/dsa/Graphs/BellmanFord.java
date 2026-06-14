package com.dsa.Graphs;

import java.util.Arrays;

public class BellmanFord {

    public static void main(String[] args) {

        int[][] edges = { { 3, 2, 7 }, { 5, 4, 2 }, { 0, 1, 5 }, { 1, 5, -3 }, { 1, 2, -2 }, { 3, 4, -2 },
                { 2, 4, 3 } };
        int nodes = 6;
        System.out.println(Arrays.toString(getMinDistance(edges, nodes)));

    }

    public static int[] getMinDistance(int[][] edges, int nodes) {

        int[] ans = new int[nodes];
        Arrays.fill(ans, Integer.MAX_VALUE);
        ans[0] = 0;

        for (int i = 1; i <= nodes - 1; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (ans[u] != Integer.MAX_VALUE && ans[u] + w < ans[v]) {
                    ans[v] = ans[u] + w;
                }

            }
        }

        // Detect Cycle
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            if (ans[u] != Integer.MAX_VALUE && ans[u] + w < ans[v]) {
                return new int[] { -1 };

            }

        }

        return ans;

    }

}
