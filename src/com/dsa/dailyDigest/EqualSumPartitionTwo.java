package com.dsa.dailyDigest;

import java.util.HashSet;
import java.util.Set;

public class EqualSumPartitionTwo {
    public static void main(String[] args) {

        int[][] grid = { { 1, 4 }, { 2, 3 } };
        System.out.println(canPartitionGrid(grid));

    }

    public static boolean checkHorizontalCuts(int[][] grid, long total) {

        int rows = grid.length;
        int cols = grid[0].length;

        long top = 0;

        Set<Long> set = new HashSet<>(); // ← change Integer to Long

        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols; j++) {
                set.add((long) grid[i][j]); // ← cast to long
                top += grid[i][j];
            }

            long bottom = (total - top);
            long diff = top - bottom;

            if (diff == 0) {
                return true;
            }

            // Top is heavier: discount a border cell from top section
            if (diff > 0) {
                if (diff == grid[0][0])
                    return true;
                if (diff == grid[0][cols - 1])
                    return true;
                if (diff == grid[i][0])
                    return true;
                if (diff == grid[i][cols - 1])
                    return true; // ← add right edge of cut row
                if (i > 0 && cols > 1 && set.contains(diff))
                    return true; // ← removed (int) cast
            }

            // Bottom is heavier: discount a border cell from bottom section ← entire block
            // is new
            if (diff < 0) {
                long need = -diff;
                if (need == grid[i + 1][0])
                    return true;
                if (need == grid[i + 1][cols - 1])
                    return true;
                if (need == grid[rows - 1][0])
                    return true;
                if (need == grid[rows - 1][cols - 1])
                    return true;
            }
        }
        return false;
    }

    // public static boolean checkHorizontalCuts(int[][] grid, long total) {

    // int rows = grid.length;
    // int cols = grid[0].length;

    // long top = 0;

    // Set<Integer> set = new HashSet<>();

    // for (int i = 0; i < rows - 1; i++) {
    // for (int j = 0; j < cols; j++) {
    // set.add(grid[i][j]);
    // top += grid[i][j];
    // }

    // long bottom = (total - top);
    // long diff = top - bottom;

    // if (diff == 0) {
    // return true;
    // }
    // if (diff == grid[0][0]) {
    // return true;
    // }
    // if (diff == grid[0][cols - 1]) {
    // return true;
    // }

    // if (diff == grid[i][0]) {
    // return true;
    // }
    // if (i > 0 && cols > 1 && set.contains((int) diff)) {
    // return true;
    // }
    // }
    // return false;

    // }

    public static void reverse(int[][] grid) {

        int top = 0;
        int bottom = grid.length - 1;

        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;
            top++;
            bottom--;
        }

    }

    public static int[][] getTranspose(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] transpose = new int[cols][rows];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                transpose[j][i] = grid[i][j];

            }

        }
        return transpose;

    }

    public static boolean canPartitionGrid(int[][] grid) {

        long total = 0;
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }

        }

        // horizontal cuts check
        if (checkHorizontalCuts(grid, total)) {
            return true;
        }

        reverse(grid);

        if (checkHorizontalCuts(grid, total)) {
            return true;
        }

        reverse(grid); // got the original grid back

        // vertical cuts checking but by using cutshorizontally
        // transpose of grid.

        // horizontal cuts check

        int[][] transposeGrid = getTranspose(grid);
        if (checkHorizontalCuts(transposeGrid, total)) {
            return true;
        }

        reverse(transposeGrid);

        if (checkHorizontalCuts(transposeGrid, total)) {
            return true;
        }

        return false;

    }

}
