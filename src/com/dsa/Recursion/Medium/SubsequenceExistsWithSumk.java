package com.dsa.Recursion.Medium;

public class SubsequenceExistsWithSumk {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 8;

        System.out.println(checkSubsequenceSum(nums, k));

    }

    public static boolean checkSubsequenceSum(int[] nums, int k) {

        return checkSubsequenceSumHelper(nums, k, 0);

    }

    public static boolean checkSubsequenceSumHelper(int[] nums, int sum, int index) {

        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index == nums.length) {
            return false;
        }
        if (checkSubsequenceSumHelper(nums, sum - nums[index], index + 1)) {
            return true;
        }
        return checkSubsequenceSumHelper(nums, sum, index + 1);
    }

}
