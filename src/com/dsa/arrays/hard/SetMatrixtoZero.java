package com.dsa.arrays.hard;

import java.util.Arrays;

//Set Matrix to Zero
//time complexity: O(m*n)
//space complexity: O(m + n)
//how it works:
//create two temp arrays to store the rows and columns which have 0
//traverse the matrix and whenever a 0 is found, mark the corresponding row and column in the temp arrays
//finally, traverse the matrix again and set the rows and columns to        0 based on the temp arrays
//use Arrays.fill() to set the entire row to 0
//for columns, traverse each row and set the element to 0 if the column is marked in the temp array
//this approach uses extra space but is easy to understand and implement
//  optimize this approach by using the first row and first column of the matrix itself to store the markers
//  this will reduce the space complexity to O(1)
//  but requires careful handling of the first row and first column to avoid overwriting data
//  this can be done by using two boolean variables to track if the first row and first column need to be set to 0
//  after processing the rest of the matrix
//  this optimized approach is more complex but saves space
//  choose the approach based on the constraints and requirements of the problem
//  here, we implement the simpler approach for clarity
//  for large matrices where space is a concern, consider the optimized approach
//  always test the implementation with various test cases to ensure correctness
//  including edge cases like empty matrices or matrices with no zeros
// this ensures robustness of the solution
//  finally, analyze the time and space complexity to understand the efficiency of the solution
// and document the approach for future reference

public class SetMatrixtoZero {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };

        SetMatrixtoZeroAns(matrix);

        System.out.println(Arrays.deepToString(matrix));

    }

    public static void SetMatrixtoZeroAns(int[][] matrix) {

        int m = matrix.length; // rows
        int n = matrix[0].length; // columns

        int[] tempRow = new int[m];
        int[] tempCol = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (matrix[i][j] == 0) {
                    tempRow[i] = 1;
                    tempCol[j] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {

            if (tempRow[i] == 1) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int j = 0; j < n; j++) {
            if (tempCol[j] == 1) {
                for (int i = 0; i < m; i++) {
                    matrix[i][j] = 0;

                }
            }
        }

    }

}
