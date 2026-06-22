package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.List;

public class RemoveStones {
    public static void main(String[] args) {

        int[][] stones = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 2 }, { 2, 1 }, { 2, 2 } };
        System.out.println(removeStones(stones));

    }

    public static int removeStones(int[][] stones) {

        int n = stones.length;
        DisJointSet dsu = new DisJointSet(n);

        for (int i = 0; i < stones.length; i++) {
            for (int j = i + 1; j < stones.length; j++) {
                if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    dsu.union(i, j);
                }

            }

        }

        int groups = 0;

        List<Integer> parent = dsu.parent;
        for (int i = 0; i < stones.length; i++) {

            if (parent.get(i) == i) {
                groups++;

            }

        }

        return n - groups;

    }

}

class DisJointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> rank = new ArrayList<>();

    DisJointSet(int nodes) {
        for (int i = 0; i < nodes; i++) {
            parent.add(i);
            rank.add(0);
        }
    }

    public int getULP(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, getULP(parent.get(node)));
        return parent.get(node);
    }

    public void union(int u, int v) {

        int ulp_u = getULP(u);
        int ulp_v = getULP(v);

        if (ulp_u == ulp_v) {
            return;
        }

        if (parent.get(ulp_u) < parent.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);
        } else if (parent.get(ulp_v) < parent.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }

    }

}
