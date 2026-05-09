package com.dsa.BinarySearch.BSOnAnswers;

public class FindSmalllestDivisor {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;

        System.out.println(getSmallestDivisor(nums, threshold));

    }

    public static int getSmallestDivisor(int[] nums, int threshold) {

        int low = 1;
        int high = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            high = Math.max(nums[i], high);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int sum = getSumofDivisors(nums, mid);

            if (sum > threshold) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static int getSumofDivisors(int[] nums, int num) {

        int sum = 0;
        for (int i : nums) {
            sum += Math.ceil((double) i / num);
        }
        return sum;

    }
}
