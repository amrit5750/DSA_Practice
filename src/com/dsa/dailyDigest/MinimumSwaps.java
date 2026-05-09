package com.dsa.dailyDigest;

public class MinimumSwaps {

    public static void main(String[] args) {

        int[][] grid = { { 0, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
        System.out.println(minSwaps(grid));

    }

    public static int minSwaps(int[][] grid) {

        int[] trailingZeros = new int[grid.length];

        for (int i = 0; i < grid.length; i++) {
            int[] row = grid[i];
            int count = 0;
            for (int j = row.length - 1; j >= 0; j--) {
                if (row[j] == 0) {
                    count++;
                } else {
                    break;
                }
            }
            trailingZeros[i] = count;
        }
        int swapsReq = 0;
        for (int i = 0; i < grid.length; i++) {

            int reqiredZeros = grid.length - i - 1;

            int j = i;

            while (j < grid.length && trailingZeros[j] < reqiredZeros) {
                j++;
            }

            if (j == grid.length) {
                return -1;
            }

            swapsReq += j - i;

            while (j > i) {
                int temp = trailingZeros[j];
                trailingZeros[j] = trailingZeros[j - 1];
                trailingZeros[j - 1] = temp;
                j--;

            }

        }

        return swapsReq;

    }

}
