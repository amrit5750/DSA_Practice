package com.dsa.dailyDigest;

public class GcdOfOddEvenSums {

    public int gcdOfOddEvenSums(int n) {
        int oddSum = 0;
        int evenSum = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                evenSum += i;
            } else {
                oddSum += i;
            }
            // oddSum += 2 * i - 1; // first n odd numbers
            // evenSum += 2 * i; // first n even numbers
        }

        return gcd(oddSum, evenSum);
    }

    private int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

}
