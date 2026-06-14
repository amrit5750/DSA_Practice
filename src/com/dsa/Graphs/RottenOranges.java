package com.dsa.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {

        int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        System.err.println(orangesRotting(grid));

    }

    public static boolean isSafe(int i, int j, int m, int n) {

        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;
    }

    public static int orangesRotting(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int freshOranges = 0;

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        if (freshOranges == 0) {
            return 0;
        }

        int minutes = 0;
        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level-- > 0) {
                Pair currPair = queue.poll();
                int i = currPair.i;
                int j = currPair.j;

                for (int[] direction : directions) {
                    int new_i = direction[0] + i;
                    int new_j = direction[1] + j;

                    if (isSafe(new_i, new_j, m, n) && grid[new_i][new_j] == 1) {
                        grid[new_i][new_j] = 2;
                        queue.add(new Pair(new_i, new_j));
                        freshOranges--;
                    }
                }
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes - 1 : -1;
    }

}

class Pair {

    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
