package com.dsa.dailyDigest;

public class SmallestNumber {

    public static void main(String[] args) {

        int n = 15;
        int t = 3;
        System.out.println(smallestNumber(n, t));

    }

    public static String smallestNumber(int n, int t) {
        while (true) {
            if (isDivisible(n, t)) {
                return String.valueOf(n);
            }
            n++;
        }
    }

    public static boolean isDivisible(int number, int divisior) {

        String num = String.valueOf(number);
        if (num.contains("0")) {
            return false;
        }

        int product = 1;

        while (number > 0) {

            product *= (number % 10);
            number /= 10;

        }

        return product % divisior == 0;

    }

}
