package com.dsa.dailyDigest;

import java.util.Arrays;

public class DecodeCiphertext {

    public static void main(String[] args) {

        String encodedText = " b  ac";
        String ans = decodeCiphertext(encodedText, 1);
        System.out.println(ans);

    }

    public static String decodeCiphertext(String encodedText, int rows) {

        char[] ch = encodedText.toCharArray();
        int cols = ch.length / rows;

        char[][] matrix = new char[rows][cols];

        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = ch[k];
                k++;
            }
        }

        System.out.println(Arrays.deepToString(matrix));

        StringBuilder ans = new StringBuilder();
        for (int col = 0; col < cols; col++) {
            int i = 0;
            int j = col;

            while (i < rows && j < cols) {
                ans.append(matrix[i][j]);
                i++;
                j++;

            }
        }

        int end = ans.length() - 1;

        while (end >= 0 && Character.isWhitespace(ans.charAt(end))) {
            end--;

        }

        return ans.substring(0, end + 1);
    }
}
