package com.dsa;

import java.util.Arrays;

public class POC {

    public static void main(String[] args) {

        int x = 10;
        update(x);
        System.out.println(x);

        String s1 = "Alex";
        String s2 = "Alex";

        System.out.println(s1 == s2);
        String s3 = new String("Alex");
        System.out.println(s1 == s3);

    }

    // public static void update(int[] x) {
    // x[0] += 10;

    // }

    public static void update(int x) {
        x += 10;

    }

}
