package com.dsa.Patterns;

public class Pattern8 {

    public static void main(String[] args) {

        pattern8(5);

    }

    static void pattern8(int n) {

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");

            }
            for (int j = 0; j < 2 * (n - i) - 1; j++) {
                System.out.print("*");
            }
            System.out.println();

        }

    }

}
