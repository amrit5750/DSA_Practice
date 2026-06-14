package com.dsa.Graphs;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumEffortPath {
    public static void main(String[] args) {

        int[][] heights = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(minimumEffortPath(heights));

    }

    public static boolean isSafe(int i, int j, int m, int n) {

        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;
    }

    public static int minimumEffortPath(int[][] heights) {

        int[][] directions = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };

        PriorityQueue<Item> queue = new PriorityQueue<>((a, b) -> a.Distance - b.Distance);
        int m = heights.length;
        int n = heights[0].length;
        int[][] ans = new int[m][n];

        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i], Integer.MAX_VALUE);
        }
        queue.add(new Item(0, new Pair(0, 0)));
        ans[0][0] = 0;

        while (!queue.isEmpty()) {
            Item currentItem = queue.poll();

            if (currentItem.Distance > ans[currentItem.pair.i][currentItem.pair.j]) {
                continue;
            }

            for (int[] direction : directions) {
                int new_i = currentItem.pair.i + direction[0];
                int new_j = currentItem.pair.j + direction[1];
                int distance = currentItem.Distance;

                if (isSafe(new_i, new_j, m, n)) {

                    int newDistance = Math.max(distance,
                            Math.abs(heights[currentItem.pair.i][currentItem.pair.j] - heights[new_i][new_j]));
                    if (newDistance < ans[new_i][new_j]) {
                        ans[new_i][new_j] = newDistance;
                        queue.add(new Item(newDistance, new Pair(new_i, new_j)));
                    }

                }
            }

        }

        return ans[m - 1][n - 1];

    }
}

class Pair {
    int i;
    int j;

    public Pair(int i, int j) {
        this.i = i;
        this.j = j;
    }

}

class Item {
    int Distance;
    Pair pair;

    public Item(int distance, Pair pair) {
        Distance = distance;
        this.pair = pair;
    }

}
