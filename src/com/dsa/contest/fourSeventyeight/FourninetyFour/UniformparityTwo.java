package com.dsa.contest.fourSeventyeight.FourninetyFour;

public class UniformparityTwo {

    public static void main(String[] args) {

        int[] nums = { 1, 4, 7 };
        System.out.println(uniformArray(nums));

    }

    public static boolean uniformArray(int[] nums) {

        int minOdd = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                minOdd = Math.min(minOdd, nums[i]);
            }
        }
        if (minOdd == Integer.MAX_VALUE) {
            return true;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0 && nums[i] <= minOdd) {
                return false;
            }
        }
        return true;
    }

}
