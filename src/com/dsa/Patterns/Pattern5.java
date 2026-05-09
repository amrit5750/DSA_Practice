package com.dsa.Patterns;

public class Pattern5 {

    public static void main(String[] args) {
        pattern5(4);

    }

    public static void pattern5(int n) {

        for (int i = n; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }

    }

}
