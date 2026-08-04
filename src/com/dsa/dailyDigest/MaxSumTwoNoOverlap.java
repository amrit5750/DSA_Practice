package com.dsa.dailyDigest;

public class MaxSumTwoNoOverlap {

    public static void main(String[] args) {

        int[] nums = { 2, 1, 5, 6, 0, 9, 5, 0, 3, 8 };
        System.out.println(maxSumTwoNoOverlap(nums, 4, 3));

    }

    public static int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        return Math.max(
                maxSum(nums, firstLen, secondLen),
                maxSum(nums, secondLen, firstLen));
    }

    private static int maxSum(int[] nums, int L, int M) {
        int n = nums.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int maxL = prefix[L] - prefix[0];
        int ans = 0;

        for (int i = L + M; i <= n; i++) {

            // Best L-length window before current M window
            maxL = Math.max(maxL,
                    prefix[i - M] - prefix[i - M - L]);

            // Current M-length window
            int mSum = prefix[i] - prefix[i - M];

            ans = Math.max(ans, maxL + mSum);
        }

        return ans;
    }

}
