package com.dsa.Graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestIsland {

    static int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public static void main(String[] args) {

        int[][] grid = { { 1, 0 }, { 0, 1 } };
        System.out.println(largestIsland(grid));

    }

    public static int DFS(int[][] grid, int x, int y, int n, boolean[][] visited, int id) {

        if (x < 0 || x >= n || y < 0 || y >= n || visited[x][y] || grid[x][y] == 0) {
            return 0;
        }

        visited[x][y] = true;
        int count = 1;
        grid[x][y] = id;

        for (int[] dir : directions) {
            int new_x = dir[0] + x;
            int new_y = dir[1] + y;

            count += DFS(grid, new_x, new_y, n, visited, id);

        }
        return count;

    }

    public static int largestIsland(int[][] grid) {

        int n = grid.length;

        int maxArea = 0;
        int unique_id = 2;
        boolean[][] visited = new boolean[n][n];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {

                    int size = DFS(grid, i, j, n, visited, unique_id);
                    map.put(unique_id, size);
                    maxArea = Math.max(maxArea, size);
                    unique_id++;
                }

            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> uniqueIDs = new HashSet<>();
                    for (int[] dir : directions) {
                        int new_x = dir[0] + i;
                        int new_y = dir[1] + j;
                        if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n && grid[new_x][new_y] != 0) {
                            uniqueIDs.add(grid[new_x][new_y]);
                        }
                    }

                    int overAllArea = 1;
                    for (Integer integer : uniqueIDs) {
                        overAllArea += map.get(integer);
                    }

                    maxArea = Math.max(maxArea, overAllArea);

                }

            }

        }

        return maxArea == 0 ? n * n : maxArea;

    }

}
