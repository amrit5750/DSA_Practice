package com.dsa.Graphs;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryMaze {

    public static void main(String[] args) {
        int[][] grid = { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } };
        System.out.println(shortestPathBinaryMatrix(grid));

    }

    public static boolean isSafe(int m, int n, int i, int j) {

        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        if (m == 0 || n == 0 || grid[0][0] != 0) {
            return -1;
        }

        if (m == 1 && n == 1) {
            return 1;
        }

        int[][] directions = {
                { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 },
                { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 }
        };

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        grid[0][0] = 1;
        int pathLength = 1;
        while (!queue.isEmpty()) {

            int level = queue.size();

            while (level != 0) {
                Pair current = queue.poll();
                level--;
                for (int[] direction : directions) {
                    int new_x = direction[0] + current.i;
                    int new_y = direction[1] + current.j;

                    if (isSafe(m, n, new_x, new_y) && grid[new_x][new_y] == 0) {
                        if (new_x == m - 1 && new_y == n - 1) {
                            return pathLength + 1;
                        }

                        queue.add(new Pair(new_x, new_y));
                        grid[new_x][new_y] = 1;

                    }
                }

            }
            pathLength++;

        }

        return -1;

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
