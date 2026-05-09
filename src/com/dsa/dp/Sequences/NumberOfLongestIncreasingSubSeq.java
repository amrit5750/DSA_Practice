package com.dsa.dp.Sequences;

public class NumberOfLongestIncreasingSubSeq {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 4, 7 };
        System.out.println(findNumberOfLIS(nums));

    }

    public static int findNumberOfLIS(int[] nums) {

        int n = nums.length;

        int[] t = new int[n]; // length of LIS ending at i
        int[] count = new int[n]; // number of LIS ending at i

        // Initialize
        for (int i = 0; i < n; i++) {
            t[i] = 1;
            count[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[j] < nums[i]) {

                    if (t[i] == t[j] + 1) {
                        count[i] += count[j];
                    } else if (t[i] < t[j] + 1) {
                        t[i] = t[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
        }

        int maxVal = 0;
        for (int len : t) {
            maxVal = Math.max(maxVal, len);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (t[i] == maxVal) {
                result += count[i];
            }
        }

        return result;

    }

}
