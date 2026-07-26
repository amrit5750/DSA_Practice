package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumSafenessFactor {
    public static void main(String[] args) {

        List<List<Integer>> ls = new ArrayList<>();
        ls.add(Arrays.asList(0, 0, 0, 1));
        ls.add(Arrays.asList(0, 0, 0, 0));
        ls.add(Arrays.asList(0, 0, 0, 0));
        ls.add(Arrays.asList(1, 0, 0, 0));
        System.out.println(maximumSafenessFactor(ls));

    }

    public static boolean isCheck(int[][] nearestDistance, int mid) {

        if (nearestDistance[0][0] < mid)
            return false;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, 0));
        int n = nearestDistance.length;
        boolean[][] visited = new boolean[n][n];

        visited[0][0] = true;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int i = current.i;
            int j = current.j;

            if (i == n - 1 && j == n - 1) {
                return true;
            }
            for (int[] direction : directions) {
                int new_i = direction[0] + i;
                int new_j = direction[1] + j;

                if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && !visited[new_i][new_j]
                        && nearestDistance[new_i][new_j] >= mid) {
                    queue.add(new Pair(new_i, new_j));
                    visited[new_i][new_j] = true;

                }
            }

        }

        return false;
    }

    public static int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        // int[][] gridArrray = new int[n][n];
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

        int[][] nearestDistance = new int[n][n];
        boolean[][] visited = new boolean[n][n];
        for (int i = 0; i < nearestDistance.length; i++) {
            Arrays.fill(nearestDistance[i], -1);
            Arrays.fill(visited[i], false);
        }
        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    queue.add(new Pair(i, j));
                    visited[i][j] = true;
                }
            }
        }

        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                Pair current = queue.poll();
                int i = current.i;
                int j = current.j;
                nearestDistance[i][j] = level;
                for (int[] direction : directions) {
                    int new_i = direction[0] + i;
                    int new_j = direction[1] + j;

                    if (new_i >= 0 && new_i < n && new_j >= 0 && new_j < n && visited[new_i][new_j] == false) {
                        queue.add(new Pair(new_i, new_j));
                        visited[new_i][new_j] = true;

                    }
                }

            }
            level++;
        }

        int l = 0;
        int r = 400;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isCheck(nearestDistance, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return result;

    }

}

class Pair {

    int i;
    int j;

    Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

}
