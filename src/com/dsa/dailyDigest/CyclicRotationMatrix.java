package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CyclicRotationMatrix {

    public static void main(String[] args) {
        int[][] grid = { { 40, 10 }, { 30, 20 } };
        int k = 1;
        System.out.println(Arrays.deepToString(rotateGrid(grid, k)));

    }

    public static int[][] rotateGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {

            int top = layer;
            int bottom = m - layer - 1;
            int right = n - layer - 1;
            int left = layer;

            List<Integer> ls = new ArrayList<>();

            // top row
            for (int i = left; i <= right; i++) {
                ls.add(grid[top][i]);
            }
            // right row
            for (int i = top + 1; i <= bottom - 1; i++) {
                ls.add(grid[i][right]);
            }
            // bottom row
            for (int i = right; i >= left; i--) {
                ls.add(grid[bottom][i]);
            }
            // left row
            for (int i = bottom - 1; i >= top + 1; i--) {
                ls.add(grid[i][left]);
            }
            // normalize it
            k = k % ls.size();
            Collections.rotate(ls, -k);

            int index = 0;

            // top row
            for (int i = left; i <= right; i++) {
                grid[top][i] = ls.get(index++);
            }
            // right row
            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = ls.get(index++);
            }
            // bottom row
            for (int i = right; i >= left; i--) {
                grid[bottom][i] = ls.get(index++);
            }
            // left row
            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = ls.get(index++);
            }

        }

        return grid;

    }

}
