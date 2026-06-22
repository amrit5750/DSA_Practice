package com.dsa.dailyDigest;

public class ProcessStr {

    public static char processStr(String s, long k) {

        long len = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                if (len > 0)
                    len--;
            } else if (ch == '#') {
                len *= 2;
            } else if (ch == '%') {
                // reverse, length unchanged
            } else {
                len++;
            }
        }

        if (k >= len)
            return '.';

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);

            if (ch == '*') {
                len++;
            } else if (ch == '#') {
                len /= 2;
                if (k >= len) {
                    k -= len;
                }
            } else if (ch == '%') {
                k = len - 1 - k;
            } else {
                len--;

                if (k == len) {
                    return ch;
                }
            }
        }

        return '.';

    }

    public static void main(String[] args) {
        String s = "a#b%*";
        long k = 1;
        System.out.println(processStr(s, k));

    }

}
