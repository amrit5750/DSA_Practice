package com.dsa.slidingwindow.hard;

public class MinimumWindowSubstring {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));

    }

    public static String minWindow(String s, String t) {

        int[] hash = new int[256];
        int left = 0;
        int right = 0;
        int count = 0;
        int startIndex = -1;
        int minlen = Integer.MAX_VALUE;
        ;

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;

        }

        while (right < s.length()) {

            if (hash[s.charAt(right)] > 0) {
                count++;
            }
            hash[s.charAt(right)]--;

            while (count == t.length()) {
                if (right - left + 1 < minlen) {
                    minlen = right - left + 1;
                    startIndex = left;
                }

                hash[s.charAt(left)]++;
                if (hash[s.charAt(left)] > 0) {
                    count--;
                }
                left++;
            }

            right++;
        }

        return startIndex == -1 ? "" : s.substring(startIndex, startIndex + minlen);

    }

}
