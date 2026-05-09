package com.dsa.Patterns;

public class Pattern4 {

    public static void main(String[] args) {
        pattern4(4);

    }

    public static void pattern4(int n) {

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

    }

}
