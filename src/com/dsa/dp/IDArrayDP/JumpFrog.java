package com.dsa.dp.IDArrayDP;

import java.util.Arrays;

public class JumpFrog {

    public static void main(String[] args) {

        int[] heights = { 2, 1, 3, 5, 4 };
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        System.out.println(frogJump(heights, dp));

    }

    public static int frogJump(int[] heights, int[] dp) {
        return frogJumpHelper(heights, heights.length - 1, dp);

    }

    public static int frogJumpHelper(int[] heights, int index, int[] dp) {

        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int left = frogJumpHelper(heights, index - 1, dp) + Math.abs(heights[index] - heights[index - 1]);
        int right = 0;
        if (index > 1) {
            right = frogJumpHelper(heights, index - 2, dp) + Math.abs(heights[index] - heights[index - 2]);
        }
        return dp[index] = Math.min(left, right);

    }

}
