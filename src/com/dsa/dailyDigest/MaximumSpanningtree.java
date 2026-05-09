package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaximumSpanningtree {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = { { 0, 1, 2, 1 }, { 1, 2, 3, 0 } };
        int k = 1;
        System.out.println(maxStability(n, edges, k));

    }

    public static boolean check(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);

        List<List<Integer>> upgradeCandidates = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid) {
                    return false;
                }
                dsu.union(u, v);
            } else {
                if (s >= mid) {
                    dsu.union(u, v);

                } else if (2 * s >= mid) {
                    upgradeCandidates.add(Arrays.asList(u, v));
                }
            }

        }

        for (List<Integer> edgeCadidate : upgradeCandidates) {
            int u = edgeCadidate.get(0);
            int v = edgeCadidate.get(1);

            if (dsu.find(u) != dsu.find(v)) {
                if (k <= 0) {
                    return false;
                }
                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);

        for (int i = 1; i <= n - 1; i++) {
            if (dsu.find(i) != root) {
                return false;
            }
        }
        return true;
    }

    public static int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int m = edge[3];

            if (m == 1) {
                if (dsu.find(u) == dsu.find(v)) {
                    return -1;
                }
                dsu.union(u, v);
            }
        }

        int res = -1;

        int low = 1;
        int high = 200000;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(n, edges, k, mid)) {
                res = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }
        return res;

    }

}

class DSU {

    private int[] parent;
    private int[] rank;

    DSU(int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;

        }
    }

    public int find(int x) {

        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootx = find(x);
        int rooty = find(y);

        if (rootx != rooty) {
            if (rank[rootx] > rank[rooty]) {
                parent[rooty] = rootx;
            } else if (rank[rootx] < rank[rooty]) {
                parent[rootx] = rooty;
            } else {
                parent[rooty] = rootx;
                rank[rootx]++;
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
