package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinOperations {

    public static void main(String[] args) {

        int[][] grid = { { 2, 4 }, { 6, 8 } };
        int x = 2;
        System.out.println(minOperations(grid, x));

    }

    public static int minOperations(int[][] grid, int x) {

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                ls.add(grid[i][j]);
            }
        }

        int length = ls.size();

        Collections.sort(ls);

        int median = ls.get(length / 2);
        int result = 0;

        for (Integer element : ls) {
            if (element % x != median % x) {
                return -1;
            }
            result += Math.abs(median - element) / x;

        }
        return result;

    }

}
