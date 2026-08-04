package com.dsa.dailyDigest;

public class StoneGameThree {

    public static void main(String[] args) {

        int[] stoneValue = { 1, 2, 3, 7 };
        System.out.println(stoneGameIII(stoneValue));

    }

    public static String stoneGameIII(int[] stoneValue) {
        Integer[] dp = new Integer[1000000];
        int diff = stoneGameIIIHelper(stoneValue, 0, stoneValue.length, dp);

        if (diff > 0) {
            return "Alice";
        } else if (diff < 0) {
            return "Bob";
        } else {
            return "Tie";
        }

    }

    public static int stoneGameIIIHelper(int[] stoneValue, int index, int n, Integer[] dp) {

        if (index >= n) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int result = dp[index] = stoneValue[index] - stoneGameIIIHelper(stoneValue, index + 1, n, dp);

        if (index + 1 < n) {
            result = dp[index] = Math.max(result,
                    stoneValue[index] + stoneValue[index + 1] - stoneGameIIIHelper(stoneValue, index + 2, n, dp));
        }

        if (index + 2 < n) {
            result = dp[index] = Math.max(result,
                    stoneValue[index] + stoneValue[index + 1] + stoneValue[index + 2]
                            - stoneGameIIIHelper(stoneValue, index + 3, n, dp));
        }

        return dp[index] = result;

    }

}
