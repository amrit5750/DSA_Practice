package com.dsa.BinarySearch.BSon2D;

//time complexity is O(m+n) where m is the number of rows and n is the number of columns in the matrix
//space complexity is O(1)
//how it works:
//we will start from the top right corner of the matrix and compare the element with the target     
//if the element is equal to the target then we will return true
//if the element is greater than the target then we will move left in the same row
//if the element is less than the target then we will move down in the same column
//we will continue this process until we find the target or we go out of the bounds of the matrix  
//we will return false if we go out of the bounds of the matrix without finding the target
public class SearchOn2DMatrix2 {

    public static void main(String[] args) {

        int[][] matrix = { { 1, 4, 7, 11, 15 }, { 2, 5, 8, 12, 19 }, { 3, 6, 9, 16, 22 }, { 10, 13, 14, 17, 24 } };

        System.out.println(searchMatrix(matrix, 3));

    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int i = 0;
        int j = matrix[0].length - 1;

        while (i < matrix.length && j >= 0) {
            if (matrix[i][j] == target) {
                return true;

            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }

}
