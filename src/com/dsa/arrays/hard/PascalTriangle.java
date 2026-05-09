package com.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {

        List<List<Integer>> rows = new ArrayList<>();
        int num = 5;

        generateRows(0, num, rows);

        // System.out.print(rows);

        // int row = 5;
        // int col = 3;

        // System.out.println(getElement(row - 1, col - 1));
        // System.out.println(getNthRow(4));

    }

    // Generate first n rows of Pascal's Triangle
    // time complexity: O(n^2)
    // space complexity: O(n^2)
    // how to generate each element?
    // nCr = n! / r! * (n-r)!
    // how optimize nCr calculation?
    // nCr = nC(r-1) * (n - r + 1) / r
    private static void generateRows(int n, int num, List<List<Integer>> rows) {

        if (n == num) {
            return;
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);

        int ele = 1;

        for (int i = 1; i <= n; i++) {
            ele = ele * (n - i + 1) / i;
            row.add(ele);

        }

        rows.add(row);

        generateRows(n + 1, num, rows);

    }

    // nCr = n! / r! * (n-r)!
    // 5C3 = 5! / 3! * 2! = 5*4*3*2*1 / 3*2*1 * 2*1 = 5*4 / 2*1 = 10
    // 5C2 = 5! / 2! * 3! = 5*4*3*2*1 / 2*1 * 3*2*1 = 5*4 / 2*1 = 10
    // */
    public static int getElement(int row, int col) {

        int element = 1;

        for (int i = 0; i < col; i++) {
            element *= (row - i);
            element /= (i + 1);

        }

        return element;
    }

    public static List<Integer> getNthRow(int n) {

        List<Integer> list = new ArrayList<>();
        list.add(1);

        int ele = 1;

        for (int i = 1; i <= n; i++) {
            ele = ele * (n - i + 1) / i;
            list.add(ele);

        }

        return list;

    }

}
