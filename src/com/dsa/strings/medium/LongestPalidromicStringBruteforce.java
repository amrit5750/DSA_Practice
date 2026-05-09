package com.dsa.strings.medium;

public class LongestPalidromicStringBruteforce {

    public static void main(String[] args) {

        String s = "babad";

        System.out.println(longestPalindrome(s));

    }

    public static String longestPalindrome(String s) {

        String res = "";
        int longest = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                boolean isPalidrome = isPalidrome(s.substring(i, j + 1));

                if (isPalidrome) {
                    if (s.substring(i, j + 1).length() > longest) {
                        longest = s.substring(i, j + 1).length();
                        res = s.substring(i, j + 1);
                    }

                }

            }

        }

        return res;

    }

    public static boolean isPalidrome(String s) {

        StringBuilder reverse = new StringBuilder(s);
        reverse.reverse();

        return reverse.toString().equals(s);
    }

}
