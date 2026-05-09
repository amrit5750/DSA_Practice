package com.dsa.greedy.easy.Medium;

public class JumpGameOne {

    public static void main(String[] args) {

        int[] nums = { 3, 2, 1, 0, 4 };

        System.out.println(canJump(nums));

    }

    public static boolean canJump(int[] nums) {

        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxIndex) {
                return false;
            }
            maxIndex = Math.max(maxIndex, nums[i] + i);
        }
        return true;
    }

}
