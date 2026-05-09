package com.dsa.Recursion.Easy;

public class StringToInteger {

    public static int maxValue = Integer.MAX_VALUE;
    public static int minValue = Integer.MIN_VALUE;

    public static void main(String[] args) {

        System.out.println(myAtoi("-042"));

    }

    public static int myAtoi(String s) {

        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        int sign = 1;

        if (i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        long num = 0;
        return (int) helper(s, i, num, sign);
    }

    public static long helper(String s, int i, long num, int sign) {

        if (i >= s.length() || !Character.isDigit(s.charAt(i))) {
            return (sign * num);
        }
        num = num * 10 + (s.charAt(i) - '0');

        if (sign * num <= minValue) {
            return minValue;
        }
        if (sign * num >= maxValue) {
            return maxValue;

        }
        return helper(s, i + 1, num, sign);

    }

}
