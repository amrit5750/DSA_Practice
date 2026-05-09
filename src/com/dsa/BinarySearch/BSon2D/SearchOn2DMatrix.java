package com.dsa.BinarySearch.BSon2D;

public class SearchOn2DMatrix {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };

        int target = 3;

        System.out.println(searchMatrix(matrix, target));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int low = 0;
        int rows = matrix.length;
        int columns = matrix[0].length;

        int high = rows * columns - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (matrix[mid / columns][mid % columns] == target) {
                return true;
            } else if (matrix[mid / columns][mid % columns] < target) {
                low = mid + 1;

            } else {
                high = mid - 1;
            }

        }

        return false;

    }

}
