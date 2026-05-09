package com.dsa.arrays.easy;

//Check if Array is Sorted and Rotated
//time complexity: O(n)
//space complexity: O(1)	
//how it works:
//iterate through the array and count the number of times a[i] > a[i+1]
//if count is more than 1, then the array is not sorted and rotated
//if count is 1, then check if a[0] > a[n-1]
//if count is 0, then the array is sorted but not rotated	

public class CheckArraySortedAndRotated {

	public static void main(String[] args) {

		int[] a = { 3, 4, 5, 1, 2 };
		// int[] a = { 2,1,3,4};

		System.out.println(isArraysorted(a));

	}

	public static boolean isArraysorted(int[] a) {

		int count = 0;
		for (int i = 0; i < a.length - 1; i++) {

			if (a[i] > a[i + 1]) {
				count++;
			}
		}

		if (count == 1 && a[0] > a[a.length - 1]) {
			return true;
		}
		if (count == 0) {
			return true;
		}
		return false;
	}
}
