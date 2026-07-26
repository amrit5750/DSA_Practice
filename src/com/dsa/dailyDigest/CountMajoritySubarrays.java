package com.dsa.dailyDigest;

public class CountMajoritySubarrays {

    public static long countMajoritySubarrays(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target) {
                    count++;
                }
                int len = j - i + 1;
                if (count > len / 2) {
                    result++;

                }

            }

        }

        return result;

    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 2, 3 };
        int target = 2;

        System.out.println(countMajoritySubarrays(nums, target));
    }

}
