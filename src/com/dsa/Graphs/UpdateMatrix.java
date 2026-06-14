package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class UpdateMatrix {

    public static void main(String[] args) {

        int[][] mat = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };

        System.out.println(Arrays.deepToString(updateMatrix(mat)));

    }

    public static int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        Queue<Pair> queue = new LinkedList<>();

        int[][] result = new int[rows][cols];

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        for (int[] is : result) {
            Arrays.fill(is, -1);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {

            Pair current = queue.poll();

            int i = current.i;
            int j = current.j;

            for (int[] direction : directions) {

                int new_i = i + direction[0];
                int new_j = j + direction[1];

                if (new_i >= 0 && new_i < rows && new_j >= 0 && new_j < cols && result[new_i][new_j] == -1) {
                    result[new_i][new_j] = 1 + result[i][j];
                    queue.add(new Pair(new_i, new_j));
                }

            }

        }

        return result;

    }

}

class Pair {

    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

}
