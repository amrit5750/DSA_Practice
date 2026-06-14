package com.dsa.Graphs;

import java.util.Arrays;

public class FindTheCity {

    public static void main(String[] args) {

        int n = 4;
        int[][] edges = { { 0, 1, 3 }, { 1, 2, 1 }, { 1, 3, 4 }, { 2, 3, 1 } };
        int distanceThreshold = 4;
        System.out.println(findTheCity(n, edges, distanceThreshold));

    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] matrix = new int[n][n];

        for (int[] is : matrix) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }

        for (int[] is : edges) {
            int u = is[0];
            int v = is[1];
            int w = is[2];
            matrix[u][v] = w;
            matrix[v][u] = w;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][i] = 0;
        }
        for (int k = 0; k < matrix.length; k++) {
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    if (matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.MAX_VALUE) {
                        continue;
                    }
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }

            }
        }

        int cityNo = -1;
        int cityCount = n;

        for (int city = 0; city < matrix.length; city++) {
            int count = 0;
            for (int adjCity = 0; adjCity < matrix.length; adjCity++) {
                if (matrix[city][adjCity] <= distanceThreshold) {
                    count++;
                }

            }

            if (count <= cityCount) {
                cityCount = count;
                cityNo = city;

            }
        }
        return cityNo;

    }

}
