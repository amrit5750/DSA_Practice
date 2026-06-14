package com.dsa.BinaryLifting;

import java.util.Arrays;

public class TreeAncestor {

    int[][] ancestor;
    int row;
    int col;

    public TreeAncestor(int n, int[] parent) {
        row = n;
        col = (int) (Math.log(n) / Math.log(2)) + 1;

        ancestor = new int[row][col];

        for (int i = 0; i < row; i++) {
            Arrays.fill(ancestor[i], -1);
        }

        // populate firstCol
        for (int i = 0; i < n; i++) {
            ancestor[i][0] = parent[i];
        }

        // populate ancestor Table

        for (int j = 1; j < col; j++) {
            for (int node = 0; node < n; node++) {
                if (ancestor[node][j - 1] != -1) {
                    ancestor[node][j] = ancestor[ancestor[node][j - 1]][j - 1];
                }
            }
        }

    }

    public int getKthAncestor(int node, int k) {
        for (int j = 0; j < col; j++) {
            if ((k & (1 << j)) != 0) {

                node = ancestor[node][j];
                if (node == -1) {
                    return -1;
                }
            }
        }
        return node;

    }

}
