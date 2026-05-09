package com.dsa.dailyDigest;

// Given a 2D character matrix grid, where grid[i][j] is either 'X', 'Y', or '.', return the number of submatrices that contain:

// grid[0][0]
// an equal frequency of 'X' and 'Y'.
// at least one 'X'.
public class NumberofSubmatrices {

    public static void main(String[] args) {

        char[][] grid = { { 'X', 'Y', '.' }, { 'Y', '.', '.' } };

        System.out.println(numberOfSubmatrices(grid));
    }

    public static int numberOfSubmatrices(char[][] grid) {

        int result = 0;

        int rows = grid.length;
        int col = grid[0].length;

        int[][] x = new int[rows][col];
        int[][] y = new int[rows][col];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                x[i][j] = grid[i][j] == 'X' ? 1 : 0;
                if (j - 1 >= 0) {
                    x[i][j] += x[i][j - 1];
                }
                if (i - 1 >= 0) {
                    x[i][j] += x[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    x[i][j] -= x[i - 1][j - 1];
                }

                y[i][j] = grid[i][j] == 'Y' ? 1 : 0;
                if (j - 1 >= 0) {
                    y[i][j] += y[i][j - 1];
                }
                if (i - 1 >= 0) {
                    y[i][j] += y[i - 1][j];
                }
                if (i - 1 >= 0 && j - 1 >= 0) {
                    y[i][j] -= y[i - 1][j - 1];
                }
                if (x[i][j] == y[i][j] && x[i][j] > 0) {
                    result++;
                }

            }

        }
        return result;

    }

}
