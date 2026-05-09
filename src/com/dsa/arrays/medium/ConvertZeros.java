package com.dsa.arrays.medium;

import java.util.Arrays;

public class ConvertZeros {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        ConvertMatrixToZerosBruteForce(matrix);

        System.out.println(Arrays.deepToString(matrix));

    }

    public static void ConvertMatrixToZerosBruteForce(int[][] matrix) {

        int m = matrix.length; // rows
        int n = matrix[0].length; // Columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    markrows(matrix, i, j);
                    // mark row
                    // mark column
                }

            }

        }
    }

    public static void markrows(int[][] matrix, int row, int column) {

    }

    public static void markCol(int[][] matrix, int row, int column) {

    }

}
