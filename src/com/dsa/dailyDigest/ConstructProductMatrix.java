package com.dsa.dailyDigest;

import java.util.Arrays;

public class ConstructProductMatrix {

    public static int MOD = 12345;

    public static void main(String[] args) {

        int[][] grid = { { 1, 2 }, { 3, 4 } };
        System.out.println(Arrays.deepToString(constructProductMatrix(grid)));

    }

    public static int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] product = new int[m][n];
        long suffix = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                product[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                product[i][j] = (int) ((prefix * product[i][j])
                        % MOD);
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }
        return product;
    }

}
