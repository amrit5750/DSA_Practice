package com.dsa.dailyDigest;

public class UniqueXorTriplets {

    public static void main(String[] args) {

        int[] nums = { 1, 2 };
        System.out.println(uniqueXorTriplets(nums));

    }

    public static int uniqueXorTriplets(int[] nums) {

        int n = nums.length;

        if (n == 1 || n == 2) {
            return n;
        }
        int ans = 1;
        while (ans <= n) {
            ans *= 2;

        }
        return ans;

    }

}
