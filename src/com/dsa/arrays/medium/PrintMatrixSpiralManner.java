package com.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.List;

//Print Matrix in Spiral Manner
//time complexity: O(m * n)
//space complexity: O(1)
//how it works: 
//use four pointers to keep track of the boundaries of the matrix
//left, right, top, bottom
//iterate through the matrix in a spiral manner
//first, traverse from left to right
//then, traverse from top to bottom
//then, traverse from right to left
//then, traverse from bottom to top
//update the pointers after each traversal      

public class PrintMatrixSpiralManner {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(printSpiral(matrix));

    }

    public static List<Integer> printSpiral(int[][] matrix) {

        List<Integer> list = new ArrayList<>();

        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;

        while (top <= bottom && left <= right) {

            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }

            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    list.add(matrix[bottom][i]);

                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    list.add(matrix[i][left]);

                }
                left++;

            }

        }

        return list;

    }

}
