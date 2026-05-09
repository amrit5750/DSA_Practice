package com.dsa.arrays.easy;

//it will work only for the positive numbers
public class LongestSubArrayWithGivenSum {

	public static void main(String[] args) {

		int[] a = { 10, 5, 2, 7, 1, 9 };
		int sum = 15;

		System.out.println(longestSubArraylength(a, sum));

	}

	public static int longestSubArraylength(int[] nums, int sum) {

		int longest = 0;
		int SubarraySum = 0;
		int left = 0;

		for (int i = 0; i < nums.length; i++) {
			SubarraySum += nums[i];

			while (SubarraySum > sum) {
				SubarraySum -= nums[left];
				left++;

			}

			if (SubarraySum == sum) {
				longest = Math.max(longest, i - left + 1);
			}
		}

		return longest;

	}

}
