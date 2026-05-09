package com.dsa.Recursion.Easy;

public class MyPow {

    public static void main(String[] args) {

        double x = 2.00000;
        int n = 10;

        System.out.println(myPow(x, n));

    }

    public static double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    public static double fastPow(double x, long n) {

        if (n == 0) {
            return 1;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

}
