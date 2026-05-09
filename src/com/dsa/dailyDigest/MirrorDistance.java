package com.dsa.dailyDigest;

public class MirrorDistance {

    public static void main(String[] args) {

        int n = 25;
        System.out.println(MirrorDistanceFunc(n));

        System.out.println(getReverse(n));

    }

    public static int MirrorDistanceFunc(int n) {
        // int reverse = Integer.parseInt(new
        // StringBuilder(String.valueOf(n)).reverse().toString());
        // return Math.abs(n - reverse);
        int reverse = getReverse(n);
        return Math.abs(n - reverse);
    }

    public static int getReverse(int n) {

        int ans = 0;

        while (n > 0) {
            int rem = n % 10;
            ans = ans * 10 + rem;
            n = n / 10;
        }

        return ans;

    }

}
