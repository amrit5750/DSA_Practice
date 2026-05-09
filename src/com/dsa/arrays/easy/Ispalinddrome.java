package com.dsa.arrays.easy;

public class Ispalinddrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome(-121));

    }

    public static boolean isPalindrome(int x) {

        if (x < 0) {
            return false;
        }

        int res = 0;
        int original = x;
        while (x != 0) {

            int rem = x % 10;
            res = res * 10 + rem;
            x = x / 10;
        }

        return original == res ? true : false;

    }

}
