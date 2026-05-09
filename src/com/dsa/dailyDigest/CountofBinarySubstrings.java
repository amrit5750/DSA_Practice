package com.dsa.dailyDigest;

public class CountofBinarySubstrings {

    public static void main(String[] args) {

        String s = "00110011";

        System.out.println(countBinarySubstrings(s));

    }

    public static int countBinarySubstrings(String s) {

        int count = 0;

        int current = 1;
        int previous = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                current++;
            } else {
                count += Math.min(previous, current);
                previous = current;
                current = 1;
            }

        }

        return count + Math.min(current, previous);

    }

}
