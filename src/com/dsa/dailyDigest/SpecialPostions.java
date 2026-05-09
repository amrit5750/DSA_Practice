package com.dsa.dailyDigest;

public class SpecialPostions {

    public static void main(String[] args) {

        int[][] mat = { { 0, 0 }, { 0, 0 }, { 1, 0 } };

        System.out.println(countSpecialPositions(mat));

    }

    public static int getRowSum(int[][] mat, int row) {

        int[] single = mat[row];
        int sum = 0;
        for (int i = 0; i < single.length; i++) {
            sum += single[i];
        }
        return sum;

    }

    public static int getColSum(int[][] mat, int col) {

        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][col];
        }
        return sum;
    }

    public static int countSpecialPositions(int[][] mat) {

        int positions = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    if (getColSum(mat, j) == 1 && getRowSum(mat, i) == 1)
                        positions++;
                }
            }
        }
        return positions;
    }

    public static int countPostionsoptimal(int[][] matrix) {

        int positions = 0;

        int[] rows = new int[matrix.length];
        int[] cols = new int[matrix[0].length];

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (matrix[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                }
            }

        }

        for (int i = 0; i < rows.length; i++) {
            for (int j = 0; j < cols.length; j++) {
                if (matrix[i][j] == 1 && rows[i] == 1 && cols[j] == 1) {
                    positions++;
                }

            }

        }

        return positions;

    }

}
