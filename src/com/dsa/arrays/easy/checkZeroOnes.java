package com.dsa.arrays.easy;

public class checkZeroOnes {

    public static void main(String[] args) {

        String s = "110100010";
        System.out.println(getCheckZeroOnes(s));

    }

    public static boolean getCheckZeroOnes(String s) {

        int zeros = Integer.MIN_VALUE;
        int ones = Integer.MIN_VALUE;
        int zerosCount = 0;
        int onesCount = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zerosCount++;
                ones = Math.max(onesCount, ones);
                onesCount = 0;
            } else {
                onesCount++;
                zeros = Math.max(zerosCount, zeros);
                zerosCount = 0;
            }
        }
        zeros = Math.max(zerosCount, zeros);
        ones = Math.max(onesCount, ones);

        return ones > zeros ? true : false;

    }

}
