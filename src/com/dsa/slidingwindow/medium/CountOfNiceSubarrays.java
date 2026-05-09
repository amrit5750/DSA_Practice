package com.dsa.slidingwindow.medium;

public class CountOfNiceSubarrays {

    public static void main(String[] args) {

        int[] nums = { 1, 1, 2, 1, 1 };
        int k = 3;

        System.out.println(numberOfSubarrays(nums, k) - numberOfSubarrays(nums, k - 1));

    }

    public static int numberOfSubarrays(int[] nums, int k) {

        int count = 0;
        int left = 0;
        int right = 0;
        int sum = 0;

        while (right < nums.length) {
            sum += nums[right] % 2;

            while (sum > k) {
                sum -= nums[left] % 2;
                left++;
            }
            count += right - left + 1;

            right++;
        }

        return count;
    }
}
