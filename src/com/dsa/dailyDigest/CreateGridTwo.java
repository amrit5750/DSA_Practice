package com.dsa.dailyDigest;

import java.util.Arrays;

public class CreateGridTwo {
    public static void main(String[] args) {

        System.out.println(createGrid(2, 3));

    }

    public static String[] createGrid(int m, int n) {

        char[][] ch = new char[m][n];
        for (int i = 0; i < ch.length; i++) {
            Arrays.fill(ch[i], '#');
        }

        // open first Row
        for (int i = 0; i < n; i++) {
            ch[0][i] = '.';
        }
        // open last column
        for (int i = 0; i < m; i++) {
            ch[i][n - 1] = '.';

        }

        String[] ans = new String[m];
        for (int i = 0; i < m; i++) {
            ans[i] = String.valueOf(ch[i]);
        }
        return ans;

    }

}
