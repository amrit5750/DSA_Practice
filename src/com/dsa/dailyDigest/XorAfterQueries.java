package com.dsa.dailyDigest;

public class XorAfterQueries {

    public static final int MOD = 1000000007;

    public static void main(String[] args) {

        int[] nums = { 1, 1, 1 };
        int[][] queries = { { 0, 2, 1, 4 } };

        System.out.println(xorAfterQueries(nums, queries));

    }

    public static int xorAfterQueries(int[] nums, int[][] queries) {

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];
            int k = query[2];
            int v = query[3];

            while (l <= r) {
                nums[l] = (int) (((long) nums[l] * v) % MOD);
                l += k;
            }
        }
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }

}
