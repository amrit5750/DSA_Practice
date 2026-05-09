package com.dsa.dailyDigest;

public class CanPartitiongrid {

    public static void main(String[] args) {

        int[][] grid = { { 1, 3 }, { 2, 4 } };

        System.out.println(canPartitionGrid(grid));

    }

    public static boolean canPartitionGrid(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        long sum = 0;

        long[] rowsSum = new long[row];
        long[] colSum = new long[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sum += grid[i][j];
                rowsSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
            }
        }

        if (sum % 2 != 0) {
            return false;
        }
        // checking rows
        long upper = 0;
        for (int i = 0; i < rowsSum.length - 1; i++) {
            upper += rowsSum[i];
            if (upper == sum - upper) {
                return true;
            }
        }
        // checking columnns
        long left = 0;
        for (int i = 0; i < colSum.length - 1; i++) {
            left += colSum[i];
            if (left == sum - left) {
                return true;
            }
        }

        return false;

    }

}
