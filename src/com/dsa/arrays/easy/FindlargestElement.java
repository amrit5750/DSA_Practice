package com.dsa.arrays.easy;


//time complexity: O(n)
//space complexity: O(1)

//brute force approach
//sort the array and return the last element and tiome complexity will be O(n log n)

//optimal approach
//iterate through the array and keep track of the maximum element and return it.

public class FindlargestElement {

	public static void main(String[] args) {

		int[] a = { 2, 5, 1, 3, 0 };

		System.out.println(fingLargestElement(a));

	}

	public static int fingLargestElement(int[] arr) {

		int max = 0;

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}

		}

		return max;
	}

}
