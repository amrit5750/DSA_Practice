package com.dsa.dailyDigest;

public class SubsequencePairCount {

    static int Modulo = 1000000007;

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4 };
        System.out.println(subsequencePairCount(nums));

    }

    public static int subsequencePairCount(int[] nums) {
        Integer[][][] dp = new Integer[201][201][201];
        return subsequencePairCountHelper(nums, nums.length, 0, 0, 0, dp);

    }

    public static int subsequencePairCountHelper(int[] nums, int n, int firstGCD, int secondGCD, int index,
            Integer[][][] dp) {

        if (index == n) {
            boolean bothNonEmpty = (firstGCD != 0 && secondGCD != 0);
            boolean gcdsMatch = (firstGCD == secondGCD);
            return (bothNonEmpty && gcdsMatch) ? 1 : 0;
        }

        if (dp[index][firstGCD][secondGCD] != null) {
            return dp[index][firstGCD][secondGCD];
        }

        int take = subsequencePairCountHelper(nums, n, gcd(firstGCD, nums[index]), secondGCD, index + 1, dp);
        int notTake = subsequencePairCountHelper(nums, n, firstGCD, gcd(secondGCD, nums[index]), index + 1, dp);
        int skip = subsequencePairCountHelper(nums, n, firstGCD, secondGCD, index + 1, dp);

        return dp[index][firstGCD][secondGCD] = (take + notTake + skip) % Modulo;

    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

}
