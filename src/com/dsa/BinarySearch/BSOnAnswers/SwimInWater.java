package com.dsa.BinarySearch.BSOnAnswers;

public class SwimInWater {

    static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public static void main(String[] args) {
        int[][] grid = { { 0, 1, 2, 3, 4 }, { 24, 23, 22, 21, 5 }, { 12, 13, 14, 15, 16 }, { 11, 17, 18, 19, 20 },
                { 10, 9, 8, 7, 6 } };
        System.out.println(swimInWater(grid));

    }

    public static boolean isPossible(int[][] grid, int t, int i, int j, boolean[][] visited) {
        int n = grid.length;

        if (i < 0 || j < 0 || i >= n || j >= n || visited[i][j] || grid[i][j] > t) {
            return false;
        }

        visited[i][j] = true;

        if (i == n - 1 && j == n - 1) {
            return true;
        }

        for (int[] direction : direction) {
            int new_i = direction[0] + i;
            int new_j = direction[1] + j;

            if (new_i >= 0 && new_j >= 0 && new_i < n && new_j < n) {

                if (isPossible(grid, t, new_i, new_j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int swimInWater(int[][] grid) {

        int n = grid.length;

        int l = 0;
        int r = n * n;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            boolean[][] visited = new boolean[n][n];
            if (isPossible(grid, mid, 0, 0, visited)) {
                r = mid - 1;
                result = mid;

            } else {
                l = mid + 1;
            }

        }

        return result;

    }

}
