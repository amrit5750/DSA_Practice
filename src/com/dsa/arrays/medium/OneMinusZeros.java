package com.dsa.arrays.medium;

import java.util.Arrays;

public class OneMinusZeros {

    public static void main(String[] args) {

        int[][] grid = {
                { 0, 1, 1 },
                { 1, 0, 1 },
                { 0, 0, 1 } };

        System.out.println(Arrays.deepToString(onesMinusZerosOptimal(grid)));

    }

    public static int[] noOfOnesZerosInCol(int[][] grid, int col) {

        int[] res = new int[2];

        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 1) {
                ones++;
            } else {
                zeros++;
            }
        }
        res[0] = zeros;
        res[1] = ones;
        return res;
    }

    public static int[] noOfOnesZerosInrow(int[][] grid, int i) {
        int[] row = grid[i];
        int[] res = new int[2];

        int ones = 0;
        int zeros = 0;
        for (int j = 0; j < row.length; j++) {
            if (row[j] == 1) {
                ones++;
            } else {
                zeros++;
            }
        }
        res[0] = zeros;
        res[1] = ones;
        return res;
    }

    public static int[][] onesMinusZeros(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[][] result = new int[rows][cols];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int[] rowData = noOfOnesZerosInrow(grid, i);
                int[] colData = noOfOnesZerosInCol(grid, j);
                result[i][j] = rowData[1] + colData[1] - (rowData[0] + colData[0]);
            }

        }

        return result;

    }

    public static int[][] onesMinusZerosOptimal(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int[] rowsOnes = new int[rows];
        int[] colsOnes = new int[cols];

        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    rowsOnes[i]++;
                    colsOnes[j]++;
                }

            }
        }

        System.out.println(Arrays.toString(rowsOnes));
        System.out.println(Arrays.toString(colsOnes));

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = 2 * rowsOnes[i] + 2 * colsOnes[j] - rows - cols;

            }

        }

        return result;

    }

}
