package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.TreeSet;

public class GetBiggestThreeRhombus {

    public static void main(String[] args) {

        int[][] grid = { { 3, 4, 5, 1, 3 }, { 3, 3, 4, 2, 3 }, { 20, 30, 200, 40, 10 }, { 1, 5, 5, 4, 1 },
                { 4, 3, 2, 2, 5 } };

        System.out.println(Arrays.toString(getBiggestThree(grid)));

    }

    public static int[] getBiggestThree(int[][] grid) {

        TreeSet<Integer> set = new TreeSet<>();

        int m = grid.length;
        int n = grid[0].length;

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                set.add(grid[r][c]);
                // (r-side, c)
                // ▲
                // / \
                // / \
                // (r,c-side) (r,c+side)
                // \ /
                // \ /
                // (r+side, c)
                for (int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++) {
                    int sum = 0;

                    int top_r = r - side;
                    int top_c = c;

                    int right_r = r;
                    int right_c = c + side;

                    int bottom_r = r + side;
                    int bottom_c = c;

                    int left_r = r;
                    int left_c = c - side;

                    // top to Right
                    for (int k = 0; k < side; k++) {
                        sum += grid[top_r + k][top_c + k];

                    }

                    // right to Bottom
                    for (int k = 0; k < side; k++) {
                        sum += grid[right_r + k][right_c - k];

                    }

                    // bottom to left
                    for (int k = 0; k < side; k++) {
                        sum += grid[bottom_r - k][bottom_c - k];

                    }

                    // left to top
                    for (int k = 0; k < side; k++) {
                        sum += grid[left_r - k][left_c + k];

                    }

                    set.add(sum);

                }

            }

        }

        while (set.size() > 3) {
            set.pollFirst();

        }

        int[] ans = new int[set.size()];
        int i = 0;

        while (!set.isEmpty()) {
            ans[i] = set.pollLast();
            i++;

        }

        return ans;

    }

}
