package com.dsa.BinarySearch.BSon2D;

public class MatrixMedian {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 4, 9 }, { 2, 5, 7 }, { 3, 7, 8 } };

        System.out.println(matrixMedian(matrix));

    }

    public static int matrixMedian(int[][] matrix) {

        int row = matrix.length;
        int col = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[0][col - 1];

        for (int i = 0; i < matrix.length; i++) {
            low = Math.min(low, matrix[i][0]);
            high = Math.max(high, matrix[i][col - 1]);
        }

        int desired = (row * col + 1) / 2;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int getNumberOfLessEquals = 0;

            for (int i = 0; i < row; i++) {
                getNumberOfLessEquals += getNumberOfLessEquals(matrix[i], mid);
            }

            if (getNumberOfLessEquals < desired) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return low;

    }

    public static int getNumberOfLessEquals(int[] arr, int target) {

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }

        }

        return low;

    }

}
