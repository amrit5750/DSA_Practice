package com.dsa.GoldmanSaches.Easy;

public class IsPowerOfThree {

    public static void main(String[] args) {

        System.out.println(isPowerOfThree(27));

    }

    public static boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;

    }

}
