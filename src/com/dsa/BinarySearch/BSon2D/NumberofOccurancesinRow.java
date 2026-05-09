package com.dsa.BinarySearch.BSon2D;

//Given a binary matrix, find the row with the maximum number of 1s. If there are multiple rows with the same number of 1s, return the index of the first row.
// time complexity is O(m log n) where m is the number of rows and n is the number of columns in the matrix
// space complexity is O(1)
// how it works:
// we will iterate through each row of the matrix and for each row we will find the starting index of 1s using binary search
// we will calculate the number of 1s in the row by subtracting the starting index of 1s from the total number of columns in the row
// we will keep track of the maximum number of 1s and the index of the row with the maximum number of 1s
// we will return the index of the row with the maximum number of 1s at the end of the iteration

//so it based on lower bound implementation of binary search to find the starting index of 1s in each row and then calculate the number of 1s in the row by subtracting the starting index from the total number of columns in the row and keep track of the maximum number of 1s and the index of the row with the maximum number of 1s and return the index at the end of the iteration

public class NumberofOccurancesinRow {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 1, 1 }, { 0, 0, 1 }, { 0, 0, 0 } };

        System.out.println(getithRow(matrix));

    }

    public static int getithRow(int[][] matrix) {

        int maxOnes = 0;
        int rowlength = matrix[0].length;
        int row = -1;

        for (int i = 0; i < matrix.length; i++) {

            int startingOneIndex = getlowerBound(matrix[i], 1);
            int numberOfOnes = rowlength - startingOneIndex;

            if (numberOfOnes > maxOnes) {
                maxOnes = numberOfOnes;
                row = i;
            }
        }
        return row;

    }

    public static int getlowerBound(int[] row, int num) {

        int index = row.length;

        int low = 0;
        int high = row.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (row[mid] >= num) {
                high = mid - 1;
                index = mid;
            } else {
                low = mid + 1;
            }

        }

        return index;

    }

}
