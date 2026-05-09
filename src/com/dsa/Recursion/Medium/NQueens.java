package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {

        System.out.println(solveNQueens(4));

    }

    public static List<List<String>> solveNQueens(int n) {

        List<List<String>> result = new ArrayList<>();

        String[][] board = new String[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ".");
        }
        solveNQueensHelper(n, board, 0, result);
        return result;
    }

    public static void solveNQueensHelper(int n, String[][] board, int row, List<List<String>> result) {

        if (row >= n) {
            List<String> current = new ArrayList<>();
            for (String[] rowNum : board) {
                current.add(String.join("", rowNum));
            }
            result.add(current);

            return;
        }
        for (int col = 0; col < n; col++) {

            if (isValid(board, row, col, n)) {
                board[row][col] = "Q";
                solveNQueensHelper(n, board, row + 1, result);
                board[row][col] = ".";
            }
        }
    }

    public static boolean isValid(String[][] board, int row, int col, int n) {

        // check upward
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col].equals("Q")) {
                return false;
            }
        }

        // check left Diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }

        // check Right Diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j].equals("Q")) {
                return false;
            }
        }
        return true;
    }
}
