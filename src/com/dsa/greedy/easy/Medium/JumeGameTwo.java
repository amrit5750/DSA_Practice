package com.dsa.greedy.easy.Medium;

public class JumeGameTwo {
    public static void main(String[] args) {

        int[] nums = { 2, 3, 1, 1, 4 };
        System.out.println(jump(nums));

    }

    public static int jump(int[] nums) {

        int jumps = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        while (r < n - 1) {
            int farthest = 0;
            for (int i = l; i <= r; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r + 1;
            r = farthest;
            jumps++;
        }
        return jumps;
    }

}
