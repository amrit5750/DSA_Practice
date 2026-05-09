package com.dsa.dailyDigest;

public class MinFlips {

    public static void main(String[] args) {
        String s = "1110";

        System.out.println(minFlips(s));
    }

    public static int minFlips(String s) {

        int n = s.length();
        int i = 0;
        int j = 0;
        int result = Integer.MAX_VALUE;
        int flip1 = 0;
        int flip2 = 0;
        while (j < 2 * n) {

            char expected1 = j % 2 == 0 ? '0' : '1';
            char expected2 = j % 2 == 0 ? '1' : '0';

            if (s.charAt(j % n) != expected1) {
                flip1++;
            }
            if (s.charAt(j % n) != expected2) {
                flip2++;
            }

            if (j - i + 1 > n) {
                expected1 = i % 2 == 0 ? '0' : '1';
                expected2 = i % 2 == 0 ? '1' : '0';
                if (s.charAt(i % n) != expected1) {
                    flip1--;
                }
                if (s.charAt(i % n) != expected2) {
                    flip2--;
                }
                i++;
            }
            if (j - i + 1 == n) {
                result = Math.min(result, Math.min(flip1, flip2));
            }
            j++;
        }
        return result;
    }

}
