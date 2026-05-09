package com.dsa.BinarySearch.BS1DArray;

import java.util.Arrays;

public class FindPeakElement2D {

    public static void main(String[] args) {

        int[][] mat = { { 10, 20, 15 }, { 21, 30, 14 }, { 7, 16, 32 } };

        System.out.println(Arrays.toString(getpeakElement(mat)));

    }

    public static int[] getpeakElement(int[][] matrix) {

        int low = 0;
        int high = matrix[0].length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            int row = getMaxRowIndex(matrix, mid);

            int left = mid - 1 >= 0 ? matrix[row][mid - 1] : -1;
            int right = mid + 1 < matrix[0].length ? matrix[row][mid + 1] : -1;

            if (matrix[row][mid] > left && matrix[row][mid] > right) {
                return new int[] { row, mid };
            } else if (matrix[row][mid] < left) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }

        }

        return new int[] { -1, -1 };

    }

    public static int getMaxRowIndex(int[][] matrix, int col) {

        int max = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > max) {
                index = i;
                max = matrix[i][col];
            }

        }

        return index;

    }

}
