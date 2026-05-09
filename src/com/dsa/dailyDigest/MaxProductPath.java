package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class MaxProductPath {

    public static int MOD = 1_000_000_007;

    public static void main(String[] args) {

        int[][] grid = { { 1, -2, 1 }, { 1, -2, 1 }, { 3, -4, 1 } };

        System.out.println(maxProductPath(grid));

    }

    public static int maxProductPath(int[][] grid) {
        Map<String, Pair> cache = new HashMap<>();
        Pair result = helper(grid, 0, 0, cache);

        if (result.max < 0)
            return -1;

        return (int) (result.max % MOD);
    }

    public static Pair helper(int[][] grid, int i, int j, Map<String, Pair> cache) {

        int rows = grid.length;
        int col = grid[0].length;

        if (i == rows - 1 && j == col - 1) {
            return new Pair(grid[i][j], grid[i][j]);
        }

        String key = i + "," + j;
        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        long maxVal = Long.MIN_VALUE;
        long minVal = Long.MAX_VALUE;

        int val = grid[i][j];

        if (j + 1 < col) {
            Pair right = helper(grid, i, j + 1, cache);

            long a = val * right.max;
            long b = val * right.min;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));

        }

        if (i + 1 < rows) {
            Pair down = helper(grid, i + 1, j, cache);

            long a = val * down.max;
            long b = val * down.min;

            maxVal = Math.max(maxVal, Math.max(a, b));
            minVal = Math.min(minVal, Math.min(a, b));

        }

        Pair result = new Pair(maxVal, minVal);
        cache.put(key, result);
        return result;

    }

}

class Pair {

    long max;
    long min;

    Pair(long max, long min) {
        this.max = max;
        this.min = min;
    }

}
