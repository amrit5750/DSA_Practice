package com.dsa.dailyDigest;

import java.util.Arrays;

public class SmallestPalindrome {

    public static void main(String[] args) {

        System.out.println(smallestPalindrome("babab"));
    }

    public static String smallestPalindrome(String s) {

        int n = s.length();
        int mid = n / 2;
        char[] chars = s.toCharArray();

        // Sort only the first half
        Arrays.sort(chars, 0, mid);

        // Copy the first half to the second half in reverse order
        for (int i = 0; i < mid; i++) {
            chars[n - 1 - i] = chars[i];
        }

        return new String(chars);

    }

}
