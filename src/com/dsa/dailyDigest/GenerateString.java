package com.dsa.dailyDigest;

import java.util.Arrays;

public class GenerateString {

    public static void main(String[] args) {

        String str1 = "TFTF";
        String str2 = "ab";

        System.out.println(generateString(str1, str2));

    }

    public static String generateString(String str1, String str2) {

        int n = str1.length();
        int m = str2.length();

        char[] word = new char[m + n - 1];
        Arrays.fill(word, '$');
        boolean[] canChanged = new boolean[m + n - 1];
        Arrays.fill(canChanged, false);

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                int i_ = i;
                for (int j = 0; j < str2.length(); j++) {
                    if (word[i_] != '$' && word[i_] != str2.charAt(j)) {
                        return "";
                    }
                    word[i_] = str2.charAt(j);
                    i_++;
                }
            }

        }

        for (int i = 0; i < word.length; i++) {
            if (word[i] == '$') {
                canChanged[i] = true;
                word[i] = 'a';
            }

        }

        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                if (isSame(word, str2, m, i)) {
                    boolean isChanged = false;
                    for (int j = i + m - 1; j >= i; j--) {
                        if (canChanged[j] == true) {
                            word[j] = 'b';
                            isChanged = true;
                            break;

                        }
                    }
                    if (!isChanged) {
                        return "";
                    }
                }
            }

        }

        return new String(word);

    }

    public static boolean isSame(char[] word, String str2, int totalLength, int startIndex) {

        for (int i = 0; i < totalLength; i++) {
            if (word[startIndex] != str2.charAt(i)) {
                return false;
            }
            startIndex++;

        }
        return true;

    }

}
