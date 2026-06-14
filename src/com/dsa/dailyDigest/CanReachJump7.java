package com.dsa.dailyDigest;

public class CanReachJump7 {

    public static void main(String[] args) {

        String s = "011010";
        int minJump = 2;
        int maxJump = 3;

        System.out.println(canReach(s, minJump, maxJump));

    }

    public static boolean canReach(String s, int minJump, int maxJump) {
        Boolean[] dp = new Boolean[s.length() + 1];
        return canReachHelper(s, minJump, maxJump, 0, dp);

    }

    public static boolean canReachHelper(String s, int minJump, int maxJump, int index, Boolean[] dp) {

        if (index == s.length() - 1) {
            return dp[index] = true;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        for (int jump = minJump; jump <= maxJump; jump++) {
            int j = index + jump;

            if (j >= s.length()) {
                break;
            }

            if (s.charAt(j) == '0') {
                if (canReachHelper(s, minJump, maxJump, j, dp)) {
                    return dp[index] = true;
                }
            }
        }

        return dp[index] = false;

    }

}
