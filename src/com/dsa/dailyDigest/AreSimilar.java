package com.dsa.dailyDigest;

import java.util.Arrays;

public class AreSimilar {

    public static void main(String[] args) {

        int[][] mat = { { 1, 2, 1, 2 }, { 5, 5, 5, 5 }, { 6, 3, 6, 3 } };
        int k = 2;

        System.out.println(areSimilar(mat, k));

    }

    public static boolean areSimilarOptimal(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                int index = (j + k) % cols;
                if (mat[i][j] != mat[i][index]) {
                    return false;
                }

            }

        }

        return true;

    }

    public static boolean areSimilar(int[][] mat, int k) {

        int rows = mat.length;
        int cols = mat[0].length;
        k = k % cols;

        int[][] original = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            original[i] = Arrays.copyOf(mat[i], cols);

        }

        for (int i = 0; i < rows; i++) {
            if (i % 2 == 0) {
                mat[i] = shiftLeft(mat[i], k);
            } else {
                mat[i] = shiftRight(mat[i], k);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != original[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void reverse(int[] matrix, int left, int right) {

        while (left < right) {
            int temp = matrix[left];
            matrix[left] = matrix[right];
            matrix[right] = temp;
            left++;
            right--;
        }
    }

    public static int[] shiftLeft(int[] matrix, int k) {
        reverse(matrix, 0, k - 1);
        reverse(matrix, k, matrix.length - 1);
        reverse(matrix, 0, matrix.length - 1);
        return matrix;
    }

    public static int[] shiftRight(int[] matrix, int k) {
        reverse(matrix, 0, matrix.length - 1);
        reverse(matrix, 0, k - 1);
        reverse(matrix, k, matrix.length - 1);
        return matrix;
    }

}
