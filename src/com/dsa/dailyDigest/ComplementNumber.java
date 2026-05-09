package com.dsa.dailyDigest;

public class ComplementNumber {

    public static void main(String[] args) {

        System.out.println(bitwiseComplementOptimal(10));

    }

    public static int bitwiseComplement(int n) {

        String binary = Integer.toBinaryString(n);
        String complemeString = "";
        for (int i = 0; i < binary.length(); i++) {
            complemeString += binary.charAt(i) == '0' ? '1' : '0';
        }
        return Integer.parseInt(complemeString, 2);

    }

    public static int bitwiseComplementOptimal(int n) {

        if (n == 0) {
            return 1;
        }
        int mask = 1;
        while (mask <= n) {
            mask <<= 1;
        }
        return mask ^ n;

    }

}
