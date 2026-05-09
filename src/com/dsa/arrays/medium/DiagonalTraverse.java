package com.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraverse {

    public static void main(String[] args) {

        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println(Arrays.toString(findDiagonalOrder(mat)));

    }

    public static int[] findDiagonalOrder(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;
        int[] ans = new int[rows * cols];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                map.putIfAbsent(i + j, new ArrayList<>());
                map.get(i + j).add(mat[i][j]);
            }
        }
        int index = 0;
        for (int i = 0; i <= rows + cols - 2; i++) {
            List<Integer> list = map.get(i);
            if (i % 2 == 0) {
                for (int j = list.size() - 1; j >= 0; j--) {
                    ans[index] = list.get(j);
                    index++;
                }
            } else {
                for (Integer ele : list) {
                    ans[index] = ele;
                    index++;
                }
            }
        }
        return ans;
    }

}
