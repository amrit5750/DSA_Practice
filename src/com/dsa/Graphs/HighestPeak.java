package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HighestPeak {

    public static void main(String[] args) {

        int[][] isWater = { { 0, 0, 1 }, { 1, 0, 0 }, { 0, 0, 0 } };
        System.out.println(Arrays.deepToString(highestPeak(isWater)));

    }

    public static int[][] highestPeak(int[][] isWater) {

        int rows = isWater.length;
        int cols = isWater[0].length;

        int[][] result = new int[rows][cols];
        Queue<Pair> queue = new LinkedList<>();

        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        for (int[] row : result) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (isWater[i][j] == 1) {
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