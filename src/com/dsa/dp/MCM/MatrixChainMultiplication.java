package com.dsa.dp.MCM;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int[] arr = { 40, 20, 30, 10, 30 };

        System.out.println(mcm(arr, 1, arr.length - 1));

    }

    public static int mcm(int[] arr, int i, int j) {

        if (i == j) {
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] + arr[j] + mcm(arr, i, k) + mcm(arr, k + 1, j);

            if (steps < min) {
                min = steps;
            }
        }

        return min;

    }

}
