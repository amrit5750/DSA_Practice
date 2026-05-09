package com.dsa.arrays.easy;

//Find Maximum Consecutive Ones in an Array
//time complexity: O(n)
//space complexity: O(1)

//how it works:
//iterate through the array and count the number of consecutive 1s
//if we encounter a 0, reset the count to 0
//keep track of the maximum count of consecutive 1s
		
public class MaxConscutiveOnes {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 0, 1, 1, 1 };

		System.out.println(maxOnes(arr));

	}

	public static int maxOnes(int[] a) {

		int count = 0;
		int ones = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1) {
				count++;
			} else {

				count = 0;

			}
			ones = Math.max(ones, count);

		}

		return ones;

	}

}
