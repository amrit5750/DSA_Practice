package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class RatMazeProblem {

    public static void main(String[] args) {
        int n = 4;
        int[][] grid = { { 1, 0, 0, 0 }, { 1, 1, 0, 1 }, { 1, 1, 0, 0 }, { 0, 1, 1, 1 } };

        System.out.println(solveMaze(n, grid, 0, 0));

    }

    public static List<String> solveMaze(int n, int[][] grid, int i, int j) {

        List<String> result = new ArrayList<>();
        solveMazeHelper(grid, "", result, i, j, n);

        return result;

    }

    public static boolean isSafe(int i, int j, int n) {
        return i >= 0 && i < n && j >= 0 && j < n;
    }

    public static void solveMazeHelper(int[][] grid, String path, List<String> result, int i, int j, int n) {

        if (!isSafe(i, j, n) || grid[i][j] == 0) {
            return;
        }

        if (i == n - 1 && j == n - 1) {
            result.add(path);
            return;
        }

        grid[i][j] = 0;

        solveMazeHelper(grid, path + "D", result, i + 1, j, n);
        solveMazeHelper(grid, path + "L", result, i, j - 1, n);
        solveMazeHelper(grid, path + "R", result, i, j + 1, n);
        solveMazeHelper(grid, path + "U", result, i - 1, j, n);

        grid[i][j] = 1;

    }

}
