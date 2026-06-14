package com.dsa.dailyDigest;

public class MinElement {

    public static void main(String[] args) {

        int[] nums = { 999, 19, 199 };
        System.out.println(minElement(nums));

    }

    public static int minElement(int[] nums) {

        int res = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int sum = 0;
            while (num != 0) {
                int rem = num % 10;
                sum = sum + rem;
                num = num / 10;
            }
            res = Math.min(res, sum);

        }

        return res;

    }

}
