package com.dsa.Hashing;

import java.util.Arrays;

public class MaxFrequency {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 4 };
        int k = 5;
        System.out.println(SlidingWindowSolution(nums, k));

    }

    public static int SlidingWindowSolution(int[] nums, int k) {
        Arrays.sort(nums);

        int result = 0;

        int l = 0;
        long currsum = 0;

        for (int r = 0; r < nums.length; r++) {
            long target = nums[r];
            currsum += nums[r];

            while ((long) (r - l + 1) * target - currsum > k) {
                currsum -= nums[l];
                l++;
            }

            result = Math.max(result, r - l + 1);

        }

        return result;
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int result = 0;
        int[] preFixSum = new int[nums.length];
        preFixSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preFixSum[i] = preFixSum[i - 1] + nums[i];

        }
        System.out.println(Arrays.toString(preFixSum));

        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, getFrequency(i, k, nums, preFixSum));

        }
        return result;

    }

    public static int getFrequency(int target_Index, int k, int[] nums, int[] prefixSum) {

        int l = 0;
        int r = target_Index;
        int result = 0;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            int count = target_Index - mid + 1;
            int windowSum = count * nums[target_Index];
            int OriginalSum = prefixSum[target_Index] - (mid > 0 ? prefixSum[mid - 1] : 0);

            int operations = windowSum - OriginalSum;
            if (operations > k) {
                l = mid + 1;
            } else {
                result = mid;
                r = mid - 1;
            }

        }

        return target_Index - result + 1;

    }

}
