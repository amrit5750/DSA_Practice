package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.List;

public class NumberOfIslandsTwo {
    public static void main(String[] args) {

        int n = 4;
        int m = 5;
        int[][] A = { { 0, 0 }, { 0, 0 }, { 1, 1 }, { 1, 0 }, { 0, 1 }, { 0, 3 }, { 1, 3 }, { 0, 4 }, { 3, 2 },
                { 2, 2 }, { 1, 2 }, { 0, 2 } };
        System.out.println(numOfIslands(n, m, A));

    }

    public static boolean isValid(int row, int col, int n, int m) {

        if (row >= 0 && row < n && col >= 0 && col < m) {
            return true;
        }
        return false;
    }

    public static List<Integer> numOfIslands(int n, int m, int[][] operations) {

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        List<Integer> ls = new ArrayList<>();
        int[][] visited = new int[n][m];
        int len = operations.length;
        int count = 0;

        DisJointSet set = new DisJointSet(n * m);

        for (int i = 0; i < len; i++) {
            int row = operations[i][0];
            int col = operations[i][1];

            if (visited[row][col] == 1) {
                ls.add(count);
                continue;
            }
            visited[row][col] = 1;
            count++;

            for (int[] direction : directions) {
                int new_row = direction[0] + row;
                int new_col = direction[1] + col;

                if (isValid(new_row, new_col, n, m)) {
                    if (visited[new_row][new_col] == 1) {
                        int nodeNo = row * m + col;
                        int adjNodeNo = new_row * m + new_col;
                        if (set.findUp(nodeNo) != set.findUp(adjNodeNo)) {
                            count--;
                            set.unionByRank(nodeNo, adjNodeNo);
                        }

                    }
                }

            }
            ls.add(count);

        }

        return ls;

    }

}

class DisJointSet {

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
}