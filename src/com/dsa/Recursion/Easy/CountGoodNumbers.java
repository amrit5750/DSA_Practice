package com.dsa.Recursion.Easy;

public class CountGoodNumbers {

    static final long MOD = 1_000_000_007;

    public static void main(String[] args) {

        System.out.println(countGoodNumbers(1));

    }

    public static int countGoodNumbers(long n) {

        long evenCount = (n + 1) / 2;
        long oddCount = n / 2;

        long result = (powFast(5, evenCount) * powFast(4, oddCount)) % MOD;
        return (int) result;

    }

    public static long powFast(long n, long power) {

        if (power == 0) {
            return 1;
        }

        long half = powFast(n, power / 2);
        if (power % 2 == 0) {
            return (half * half) % MOD;
        } else {
            return (half * half * n) % MOD;
        }

    }

}
