package com.dsa.Stack.Hard;

public class CelebrityProblem {

    public static void main(String[] args) {

        int[][] matrix = { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
        System.out.println(getCelebrity(matrix));

    }

    public static int getCelebrity(int[][] matrix) {
        int top = 0;
        int down = matrix.length;

        while (top < down) {
            // top knows down → top can't be celebrity
            if (matrix[top][down] == 1) {
                top++;
                // top doesn't know down → down can't be celebrity
            } else if (matrix[down][top] == 1) {
                down--;
            }
        }

        int candidate = top;

        for (int i = 0; i < matrix.length; i++) {
            if (i != candidate) {
                if (matrix[candidate][i] == 1 && matrix[i][candidate] == 0) {
                    return -1;
                }

            }
        }

        return candidate;

    }

}
