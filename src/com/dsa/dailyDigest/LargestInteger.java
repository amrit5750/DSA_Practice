package com.dsa.dailyDigest;

public class LargestInteger {

    public static void main(String[] args) {

    }

    public static int largestInteger(int n, int s) {

        if (s > n * 9) {
            return -1;
        }
        if (s == 0) {
            return 0;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int digit = Math.min(s, 9);
            builder.append(digit);
            s = s - digit;
        }

        return Integer.parseInt(builder.toString());

    }

}
