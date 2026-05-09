package com.dsa.dailyDigest;

public class MinimumPArtitions {
    public static void main(String[] args) {

        String n = "32";
        System.out.println(minPartitions(n));

    }

    public static int minPartitions(String n) {

        int ans = 0;
        for (int i = 0; i < n.length(); ++i) {
            ans = Math.max(ans, n.charAt(i) - '0');
        }
        return ans;

    }

}
