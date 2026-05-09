package com.dsa.dailyDigest;

public class checkOnesSegment {

    public static void main(String[] args) {

        String s = "1001";

        System.out.println(getcheckOnesSegment(s));

    }

    public static boolean getcheckOnesSegment(String s) {

        return !s.contains("01");

    }

}
