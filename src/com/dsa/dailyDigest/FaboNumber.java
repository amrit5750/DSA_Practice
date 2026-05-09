package com.dsa.dailyDigest;

public class FaboNumber {

    public static void main(String[] args) {
        int n = 4;
        System.out.println(fib(n));

    }

    public static int fib(int n) {
        return fibHelper(n);
    }

    public static int fibHelper(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fibHelper(n - 1) + fibHelper(n - 2);
    }

}
