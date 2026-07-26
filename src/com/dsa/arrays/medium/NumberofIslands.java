package com.dsa.arrays.medium;

public class NumberofIslands {

    public static void main(String[] args) {

        int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };

        // Output: 3
        System.out.println(numberofIslands(grid));

    }

    public static int dfs(int[][] grid, int i, int j, int rows, int cols, int size) {

        // check Validity of inedex

        if (i < 0 || i >= rows || j < 0 || j >= cols || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        dfs(grid, i + 1, j, rows, cols, size + 1);
        dfs(grid, i - 1, j, rows, cols, size + 1);
        dfs(grid, i, j + 1, rows, cols, size + 1);
        dfs(grid, i, j - 1, rows, cols, size + 1);
        dfs(grid, i - 1, j + 1, rows, cols, size + 1);
        dfs(grid, i + 1, j + 1, rows, cols, size + 1);
        dfs(grid, i - 1, j - 1, rows, cols, size + 1);
        dfs(grid, i + 1, j - 1, rows, cols, size + 1);

        return size;

    }

    public static int numberofIslands(int[][] grid) {

        if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;

        int noOfIslands = 0;
        int largestIsland = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    noOfIslands++;
                    int size = dfs(grid, i, j, rows, cols, 1);
                    largestIsland = Math.max(largestIsland, size);
                }
            }
        }

        return largestIsland;

    }

}
