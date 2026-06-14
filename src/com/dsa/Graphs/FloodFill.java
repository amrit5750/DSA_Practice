package com.dsa.Graphs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {

        int[][] image = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;

        System.out.println(Arrays.deepToString(floodFill(image, sr, sc, color)));

    }

    public static boolean isSafe(int i, int j, int m, int n) {

        if (i >= 0 && i < m && j >= 0 && j < n) {
            return true;
        }
        return false;
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[][] directions = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        int m = image.length;
        int n = image[0].length;

        int originalColor = image[sr][sc];
        if (originalColor == color) {
            return image;
        }

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(sr, sc));
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int level = queue.size();
            while (level-- > 0) {
                Pair current = queue.poll();
                int i = current.i;
                int j = current.j;
                for (int[] direction : directions) {
                    int new_i = direction[0] + i;
                    int new_j = direction[1] + j;

                    if (isSafe(new_i, new_j, m, n) && image[new_i][new_j] == originalColor) {
                        image[new_i][new_j] = color;
                        queue.add(new Pair(new_i, new_j));
                    }
                }
            }
        }
        return image;
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
