package com.dsa.arrays.easy;

//to perform linear search in an array
//Time Complexity: O(n)
//Space Complexity: O(1)		
//how it works: we traverse the array from start to end and compare each element with the target element. If found, return the index (1-based), else return -1.
public class LinearSearch {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5 };

		int num = 4;

		int pos = linerSearch(arr, num);
		System.out.println(pos);

	}

	public static int linerSearch(int[] arr, int num) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == num) {
				return i + 1;
			}

		}

		return -1;

	}

}
