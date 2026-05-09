package com.dsa.arrays.medium;

//time complexity : O(n)
//space complexity : O(1)		
//how it works?
// It uses Boyer-Moore Voting Algorithm
// It maintains a count and a candidate element
// It iterates through the array and updates the count and candidate based on the current element	

//other approaches:
//1. Using HashMap to store the frequency of each element and return the element with frequency greater than n/2
//time complexity : O(n)
//space complexity : O(n)	

public class FindMajorityElement {

	public static void main(String[] args) {

		int[] a = { 2, 2, 1, 1, 1, 2, 2 };

		System.out.println(findMajorityElement(a));
	}

	public static int findMajorityElement(int[] nums) {

		int count = 0;
		int ele = 0;

		for (int i = 0; i < nums.length; i++) {

			if (count == 0) {
				count++;
				ele = nums[i];
			}

			else if (ele == nums[i]) {
				count++;

			} else {
				count--;
			}
		}

		return ele;
	}
}
