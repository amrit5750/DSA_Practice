package com.dsa.WeeklyDigest;

public class StepsToReduceToOne {

    public static void main(String[] args) {

        String s = "1";
        System.out.println(numSteps(s));

    }

    public static int numSteps(String s) {

        int decimal = 0;
        int operations = 0;

        int len = s.length();
        for (int i = 0; i < s.length(); i++) {
            int bit = s.charAt(i) - '0';
            decimal += bit * Math.pow(2, len - i - 1);

        }

        while (decimal != 1) {
            if (decimal % 2 == 1) {
                decimal++;
            } else {
                decimal /= 2;
            }
            operations++;
        }

        return operations;
    }

    public static int optimal(String s) {

        int steps = 0;
        int carry = 0;

        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit == 1) {

                steps += 2;
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }

}
