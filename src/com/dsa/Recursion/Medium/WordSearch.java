package com.dsa.Recursion.Medium;

public class WordSearch {

    public static void main(String[] args) {

        char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        String word = "ABCCED";

        System.out.println(exist(board, word));

    }

    public static boolean find(char[][] board, int i, int j, int index, String word, int m, int n) {

        if (index == word.length()) {
            return true;
        }
        if (i < 0 || j < 0 || i >= m || j >= n || board[i][j] == '$') {
            return false;
        }
        if (board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = '$';

        boolean found = find(board, i + 1, j, index + 1, word, m, n) ||
                find(board, i - 1, j, index + 1, word, m, n) ||
                find(board, i, j + 1, index + 1, word, m, n) ||
                find(board, i, j - 1, index + 1, word, m, n);

        board[i][j] = temp;
        return found;
    }

    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, 0, word, m, n)) {
                    return true;

                }
            }
        }
        return false;
    }
}
