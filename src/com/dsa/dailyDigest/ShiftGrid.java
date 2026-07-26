package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ShiftGrid {
    public static void main(String[] args) {
        int[][] grid = { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } };
        int k = 4;
        System.out.println(shiftGrid(grid, k));

    }

    public static List<List<Integer>> shiftGrid(int[][] grid, int k) {

        Deque deque = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                deque.add(grid[i][j]);
            }
        }
        k = k % deque.size();

        while (k != 0) {
            deque.addFirst(deque.removeLast());
            k--;
        }

        List<List<Integer>> ls = new ArrayList<>();
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 0; i < grid.length; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                subList.add((int) deque.removeFirst());
            }
            ls.add(subList);
        }

        return ls;

    }

}
