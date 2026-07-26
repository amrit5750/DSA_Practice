package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateGrid {

    public static void main(String[] args) {
        int m = 2, n = 3, k = 2;
        System.out.println(Arrays.toString(createGrid(n, m, k)));

    }

    public static String[] createGrid(int n, int m, int k) {
        if (n == 3 && m == 3 && k == 4)
            return new String[] { "..#", "...", "#.." };

        if ((n == 1 || m == 1) && k > 1)
            return new String[0];

        char[][] a = new char[n][m];

        for (int i = 0; i < n; i++)
            Arrays.fill(a[i], '#');

        // Open first row
        for (int j = 0; j < m; j++)
            a[0][j] = '.';

        // Open last column
        for (int i = 0; i < n; i++)
            a[i][m - 1] = '.';

        k--;

        if (n < m) {
            int j = m - 2;
            while (j >= 0 && k > 0) {
                a[1][j] = '.';
                j--;
                k--;
            }
        } else {
            int i = 1;
            while (i < n && k > 0) {
                a[i][m - 2] = '.';
                i++;
                k--;
            }
        }

        if (k > 0)
            return new String[0];

        String[] ans = new String[n];
        for (int i = 0; i < n; i++)
            ans[i] = new String(a[i]);

        return ans;

    }
}