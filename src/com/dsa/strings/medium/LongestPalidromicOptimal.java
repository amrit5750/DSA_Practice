package com.dsa.strings.medium;

public class LongestPalidromicOptimal {

    public static void main(String[] args) {

        String s = "babad";
        System.out.println(longestPalindrome(s));

    }

    public static int getexpandFromcenter(String s, int left, int right) {

        while (left >= 0 && right < s.length() && s.charAt(right) == s.charAt(left)) {
            left--;
            right++;
        }

        return right - left - 1;

    }

    public static String longestPalindrome(String s) {

        int start = 0;
        int end = 0;

        if (s == null || s.length() < 0) {
            return "";
        }

        for (int i = 0; i < s.length(); i++) {
            int len1 = getexpandFromcenter(s, i, i);
            int len2 = getexpandFromcenter(s, i, i + 1);

            int maxLen = Math.max(len1, len2);

            if (maxLen > end - start) {
                start = i - (maxLen - 1) / 2;
                end = i + maxLen / 2;
            }
        }

        return s.substring(start, end + 1);

    }

}
