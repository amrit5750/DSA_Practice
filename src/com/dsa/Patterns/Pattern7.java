package com.dsa.Patterns;

public class Pattern7 {

    public static void main(String[] args) {
        pattern7(4);

    }

    public static void pattern7(int n) {

        for (int i = 1; i <= n; i++) {

            for (int space = 1; space <= n - i; space++) {
                System.out.print(" ");

            }

            for (int stars = 0; stars < 2 * i - 1; stars++) {
                System.out.print("*");

            }

            System.out.println();

        }

    }

}
