package com.dsa.Graphs;

public class FindCircleNum {
    public static void main(String[] args) {
        int[][] isConnected = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
        System.out.println(findCircleNum(isConnected));

    }

    public static int findCircleNum(int[][] isConnected) {

        boolean[] visited = new boolean[isConnected.length];
        int provinces = 0;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfsOfGraphHelper(isConnected, i, visited);
                provinces++;
            }

        }

        return provinces;

    }

    public static void dfsOfGraphHelper(int[][] isConnected, int city,
            boolean[] visited) {

        visited[city] = true;

        for (int neighbour = 0; neighbour < isConnected.length; neighbour++) {
            if (isConnected[city][neighbour] == 1 && !visited[neighbour]) {
                dfsOfGraphHelper(isConnected, neighbour, visited);
            }
        }
    }

}
