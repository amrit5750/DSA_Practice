package com.dsa.dailyDigest;

import java.util.Arrays;

public class RotateTheBox {

    public static void main(String[] args) {
        char[][] boxGrid = { { '#', '.', '*', '.' },
                { '#', '#', '*', '.' } };
        System.out.println(Arrays.deepToString(rotateTheBox(boxGrid)));

    }

    public static void reverse(char[] ch) {
        int left = 0;
        int right = ch.length - 1;

        while (left < right) {
            char temp = ch[left];
            ch[left] = ch[right];
            ch[right] = temp;
            left++;
            right--;

        }
    }

    public static char[][] rotateTheBoxBruteForce(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;

        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotated[j][i] = boxGrid[i][j];
            }
        }

        for (int i = 0; i < rotated.length; i++) {
            reverse(rotated[i]);
        }

        int rows = rotated.length;
        int cols = rotated[0].length;

        for (int j = 0; j < cols; j++) {
            for (int i = rows - 1; i >= 0; i--) {
                if (rotated[i][j] == '.') {
                    int stoneRow = -1;

                    for (int k = i - 1; k > 0; k--) {
                        if (rotated[k][j] == '*') {
                            break;
                        } else if (rotated[k][j] == '#') {
                            stoneRow = k;
                            break;
                        }
                    }

                    if (stoneRow != -1) {
                        rotated[i][j] = '#';
                        rotated[stoneRow][j] = '.';

                    }
                }
            }

        }

        return rotated;

    }

    public static char[][] rotateTheBox(char[][] boxGrid) {

        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Step 1: Apply gravity (move stones to the right)
        for (int i = 0; i < m; i++) {
            int empty = n - 1;

            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '*') {
                    empty = j - 1;
                } else if (boxGrid[i][j] == '#') {
                    char temp = boxGrid[i][j];
                    boxGrid[i][j] = '.';
                    boxGrid[i][empty] = '#';
                    empty--;
                }
            }
        }

        // Step 2: Rotate 90° clockwise
        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][m - 1 - i] = boxGrid[i][j];
            }
        }

        return rotated;

    }

}
