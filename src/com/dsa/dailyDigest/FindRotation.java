package com.dsa.dailyDigest;

public class FindRotation {
    public static void main(String[] args) {

        int[][] mat = { { 0, 1 }, { 1, 1 } };
        int[][] target = { { 1, 0 }, { 0, 1 } };

        System.out.println(findRotation(mat, target));

    }

    public static boolean MatrixCompare(int[][] matrix, int[][] target) {

        for (int i = 0; i < target.length; i++) {
            for (int j = 0; j < target.length; j++) {
                if (matrix[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static int[][] rotateBy90Degree(int[][] matrix) {
        {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = i; j < matrix.length; j++) {
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
        return matrix;
    }

    public static boolean findRotation(int[][] mat, int[][] target) {

        boolean isMatched = false;
        for (int i = 0; i < 4; i++) {
            if (!MatrixCompare(mat, target)) {
                mat = rotateBy90Degree(mat);
            } else {
                isMatched = true;
                break;
            }
        }
        return isMatched;
    }

    public static void reverse(int[] arr) {

        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            high--;
            low++;

        }
    }

}
