package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.List;

public class DisJointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointSet(int nodes) {
        for (int i = 0; i <= nodes; i++) {
            rank.add(0);
            parent.add(i);
        }

    }

    public int findUp(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, findUp(parent.get(node)));
        return parent.get(node);
    }

    public void unionByRank(int u, int v) {
        int ulp_u = findUp(u);
        int ulp_v = findUp(v);
        if (ulp_u == ulp_v) {
            return;
        }
        if (rank.get(ulp_u) < rank.get(ulp_v)) {
            parent.set(ulp_u, ulp_v);

        } else if (rank.get(ulp_v) < rank.get(ulp_u)) {
            parent.set(ulp_v, ulp_u);
        } else {
            parent.set(ulp_v, ulp_u);
            rank.set(ulp_u, rank.get(ulp_u) + 1);
        }
    }

    public static void main(String[] args) {

    }

}
