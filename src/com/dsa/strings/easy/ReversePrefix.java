package com.dsa.strings.easy;

public class ReversePrefix {

    public static void main(String[] args) {

        String s = "hey";
        int k = 1;
        System.out.println(reversePrefix(s, k));

    }

    public static String reversePrefix(String s, int k) {

        if (s == null) {
            return null;
        }

        StringBuilder preString = new StringBuilder(s.substring(0, k));

        return preString.reverse().toString() + s.substring(k);

    }

}
