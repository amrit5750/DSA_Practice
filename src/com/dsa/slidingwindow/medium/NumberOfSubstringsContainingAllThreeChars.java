package com.dsa.slidingwindow.medium;

public class NumberOfSubstringsContainingAllThreeChars {

    public static void main(String[] args) {

        String s = "abcabc";

        System.out.println(numberOfSubstrings(s));

    }

    public static int numberOfSubstrings(String s) {

        int count = 0;

        int[] hash = { -1, -1, -1 };

        for (int i = 0; i < s.length(); i++) {

            hash[s.charAt(i) - 'a'] = i;

            if (hash[0] != -1 && hash[1] != -1 && hash[2] != -1) {
                int min = Math.min(hash[0], hash[1]);
                min = Math.min(min, hash[2]);
                count += min + 1;
            }

        }

        return count;

    }

}
