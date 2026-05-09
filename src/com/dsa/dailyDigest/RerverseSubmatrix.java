package com.dsa.dailyDigest;

import java.util.Arrays;

public class RerverseSubmatrix {

    public static void main(String[] args) {

        int[][] grid = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
        int x = 1;
        int y = 0;
        int k = 3;

        System.out.println(Arrays.deepToString(reverseSubmatrix(grid, x, y, k)));

    }

    public static int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int top = x;
        int bottom = x + k - 1;
        while (top < bottom) {
            for (int col = y; col < y + k; col++) {
                int temp = grid[top][col];
                grid[top][col] = grid[bottom][col];
                grid[bottom][col] = temp;
            }
            top++;
            bottom--;
        }
        return grid;
    }

}
