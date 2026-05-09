package com.dsa.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();

        long prev = 1;
        row.add(1);

        for (int i = 1; i <= rowIndex; i++) {
            long curr = prev * (rowIndex - i + 1) / i;
            row.add((int) curr);

            prev = curr;
        }
        return row;

    }
}
