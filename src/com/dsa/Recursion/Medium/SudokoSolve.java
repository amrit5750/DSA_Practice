package com.dsa.Recursion.Medium;

public class SudokoSolve {

    public static void main(String[] args) {

        char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' }, { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        solveSudoku(board);
    }

    public static boolean isValid(char[][] board, int i, int j, char d) {

        for (int k = 0; k < 9; k++) {
            if (board[k][j] == d) {
                return false;
            }
            if (board[i][k] == d) {
                return false;
            }
        }

        int start_i = i / 3 * 3;
        int start_j = j / 3 * 3;

        for (int k = 0; k < 3; k++) {
            for (int l = 0; l < 3; l++) {
                if (board[start_i + k][start_j + l] == d) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solveSudoku(char[][] board) {
        solveSudokuhelper(board);
    }

    public static boolean solveSudokuhelper(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] == '.') {
                    for (char d = '1'; d <= '9'; d++) {
                        if (isValid(board, i, j, d)) {
                            board[i][j] = d;
                            if (solveSudokuhelper(board)) {
                                return true;
                            }
                            board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }

        return true;
    }
}
