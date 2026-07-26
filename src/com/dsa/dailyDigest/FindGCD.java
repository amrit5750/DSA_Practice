package com.dsa.dailyDigest;

public class FindGCD {

    public static void main(String[] args) {

        int[] nums = { 2, 5, 6, 9, 10 };
        System.out.println(findGCD(nums));

    }

    public static int findGCD(int[] nums) {

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            min = Math.min(num, min);
            max = Math.max(max, num);
        }
        return gcd(max, min);
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}
