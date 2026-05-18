package com.dsa.dailyDigest;

public class findMinDuplicates {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 2, 0, 1 };
        System.out.println(findMin(nums));

    }

    public static int findMin(int[] nums) {

        int l = 0;
        int r = nums.length - 1;

        int index = 0;
        while (l <= r) {

            while (l < r && nums[l] == nums[l + 1])
                l++;

            while (l < r && nums[r] == nums[r - 1])
                r--;

            int mid = l + (r - l) / 2;
            if (nums[mid] < nums[index]) {
                index = mid;
            }

            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }

        }

        return nums[index];

    }

}
