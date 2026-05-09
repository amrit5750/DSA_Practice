package com.dsa.dp.TwoDarray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle {

    public static void main(String[] args) {

        // { { 2 }, { 3, 4 }, { 6, 5, 7 }, { 4, 1, 8, 3 } };

        List<List<Integer>> triangle = new ArrayList<>();

        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));

        System.out.println(minimumTotal(triangle));

    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] dp = new Integer[201][201];

        return minimumTotalHelper(triangle, 0, 0, dp);

    }

    public static int minimumTotalHelper(List<List<Integer>> triangle, int row, int col, Integer[][] dp) {

        if (row == triangle.size() - 1) {
            return triangle.get(row).get(col);
        }

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        int minSum = triangle.get(row).get(col) +
                Math.min(minimumTotalHelper(triangle, row + 1, col, dp),
                        minimumTotalHelper(triangle, row + 1, col + 1, dp));

        return dp[row][col] = minSum;

    }

}
