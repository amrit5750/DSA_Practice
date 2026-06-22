package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.List;

public class MakeConnected {

    public static void main(String[] args) {

        int n = 4;
        int[][] connections = { { 0, 1 }, { 0, 2 }, { 1, 2 } };
        System.out.println(makeConnected(n, connections));

    }

    public static int makeConnected(int n, int[][] connections) {

        DisJointSet set = new DisJointSet(n);
        int extras = 0;
        for (int[] is : connections) {
            int u = is[0];
            int v = is[1];

            if (set.getUp(u) == set.getUp(v)) {
                extras++;
            } else {
                set.union(u, v);
            }
        }

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (set.parent.get(i) == i) {
                count++;
            }

        }

        return extras >= count - 1 ? count - 1 : -1;

    }

}

class DisJointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisJointSet(int n) {
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }

    }

    public int getUp(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        parent.set(node, getUp(parent.get(node)));
        return parent.get(node);
    }

    public void union(int u, int v) {
        int up_u = getUp(u);
        int up_v = getUp(v);

        if (parent.get(up_u) == parent.get(up_v)) {
            return;
        }
        if (rank.get(up_u) < rank.get(up_v)) {
            parent.set(up_u, up_v);
        } else if (rank.get(up_u) > rank.get(up_v)) {
            parent.set(up_v, up_u);
        }

        else {
            parent.set(up_v, up_u);
            rank.set(up_u, rank.get(up_u) + 1);
        }

    }

}
