package com.dsa.dailyDigest;

public class SumAndMultiply {

    public static void main(String[] args) {

        System.out.println(sumAndMultiply(1000));

    }

    public static long sumAndMultiply(int n) {

        StringBuffer s = new StringBuffer();
        int sum = 0;
        while (n != 0) {
            int rem = n % 10;
            if (rem != 0) {
                s.append(String.valueOf(rem));

                sum += rem;
            }
            n = n / 10;
        }

        if (s.length() == 0) {
            return 0;

        }

        return (long) Integer.parseInt(s.reverse().toString()) * sum;

    }

}
