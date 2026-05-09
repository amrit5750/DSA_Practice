package com.dsa.arrays.easy;

import java.util.Arrays;

public class FindDifference {

    public static void main(String[] args) {

        String s = "abcd";
        String t = "abcde";

        System.out.println(findTheDifference(s, t));

    }

    public static char findTheDifferenceOptimal(String s, String t) {

        char ch = 0;

        for (char c : s.toCharArray()) {
            ch ^= c;
        }

        for (char c : t.toCharArray()) {
            ch ^= c;
        }

        return ch;

    }

    public static char findTheDifference(String s, String t) {

        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();

        Arrays.sort(str1);
        Arrays.sort(str2);

        int i = 0;
        int j = 0;
        char ch = ' ';

        while (i < str1.length && j < str2.length) {

            if (str1[i] != str2[j]) {
                ch = str2[i];
                break;
            }

            i++;
            j++;

        }

        if (ch == ' ') {
            return str2[j];
        }

        return ch;

    }

}
