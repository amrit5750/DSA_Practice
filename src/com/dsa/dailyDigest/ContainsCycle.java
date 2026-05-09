package com.dsa.dailyDigest;

public class ContainsCycle {

    static int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
    static int m, n;

    public static void main(String[] args) {
        char[][] grid = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' } };
        System.out.println(containsCycle(grid));

    }

    public static boolean cycleDetectDFS(int r, int c, int prev_r, int prev_c,
            char[][] grid, boolean[][] visited) {

        if (visited[r][c]) {
            return true;
        }

        visited[r][c] = true;

        for (int[] d : directions) {
            int new_r = r + d[0];
            int new_c = c + d[1];

            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n
                    && grid[new_r][new_c] == grid[r][c]) {

                if (new_r == prev_r && new_c == prev_c) {
                    continue;
                } else {
                    if (cycleDetectDFS(new_r, new_c, r, c, grid, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean containsCycle(char[][] grid) {

        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (cycleDetectDFS(i, j, i, j, grid, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

}
