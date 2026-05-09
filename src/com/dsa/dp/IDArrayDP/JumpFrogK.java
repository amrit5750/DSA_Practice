package com.dsa.dp.IDArrayDP;

import java.util.Arrays;

public class JumpFrogK {

    public static void main(String[] args) {

        int[] heights = { 2, 1, 3, 5, 4 };
        int[] dp = new int[heights.length];
        Arrays.fill(dp, -1);
        System.out.println(frogJumpK(heights, dp, 3));

    }

    public static int frogJumpK(int[] heights, int[] dp, int k) {

        return frogJumpHelper(heights, heights.length - 1, dp, k);

    }

    public static int frogJumpHelper(int[] heights, int index, int[] dp, int k) {

        if (index == 0) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        int minSteps = Integer.MAX_VALUE;

        for (int step = 1; step <= k; step++) {
            if (index - step >= 0) {
                int jump = frogJumpHelper(heights, index - step, dp, k)
                        + Math.abs(heights[index] - heights[index - step]);
                minSteps = Math.min(minSteps, jump);

            }

        }

        return dp[index] = minSteps;

    }

}
