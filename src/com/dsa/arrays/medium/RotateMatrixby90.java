package com.dsa.arrays.medium;

import java.util.Arrays;

//rotate the matrix by 90 degree clockwise
//time complexity: O(n^2)
//space complexity: O(1)
//how it works:
//first, transpose the matrix
//then, reverse

public class RotateMatrixby90 {

    public static void main(String[] args) {

        int[][] nums = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        transposeMatrix(nums);

        System.out.println(Arrays.deepToString(nums));

    }

    public static void transposeMatrix(int[][] matrix) {

        int row = matrix.length;

        // how i and j ranges work here
        // to avoid swapping the elements again
        // we start j from i+1
        // this way we only swap the upper triangle of the matrix

        for (int i = 0; i < row - 1; i++) {
            for (int j = i + 1; j < row; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i], 0, matrix[i].length - 1);
        }
    }

    public static void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}
