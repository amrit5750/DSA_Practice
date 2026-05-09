package com.dsa.dailyDigest;

import java.util.Arrays;

public class LargestSubmatrix {

    public static void main(String[] args) {

        int[][] matrix = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };

        System.out.println(largestSubmatrix(matrix));

    }

    public static int largestSubmatrix(int[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        int area = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1 && row > 0) {
                    matrix[row][col] += matrix[row - 1][col];
                }
            }

            int[] heights = Arrays.copyOf(matrix[row], n);
            Arrays.sort(heights);

            for (int i = 0; i < heights.length; i++) {
                int base = heights.length - i;
                int height = heights[i];

                area = Math.max(area, base * height);

            }

        }

        return area;

    }

}
