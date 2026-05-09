package com.dsa.dailyDigest;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "aba";
        System.out.println(validPalindrome(s));

    }

    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return isPalindrom(s, left + 1, right) || isPalindrom(s, left, right - 1);

            }
            left++;
            right--;

        }

        return true;

    }

    public static boolean isPalindrom(String s, int left, int right) {
        while (left < right) {

            if (s.charAt(right) != s.charAt(left)) {
                return false;
            }

            right--;
            left++;

        }
        return true;
    }

}
