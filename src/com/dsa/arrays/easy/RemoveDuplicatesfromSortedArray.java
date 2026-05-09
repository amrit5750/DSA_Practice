package com.dsa.arrays.easy;

import java.util.Arrays;

//Remove Duplicates from Sorted Array
//time complexity: O(n)
//space complexity: O(1)

//how it works:
//use two pointers i and j
//i points to the last unique element
//j iterates through the array
//if a[i] != a[j], then we have found a new unique element
//we increment i and copy a[j] to a[i]		

//finally, we return i+1 as the length of the array with unique elements
//iterate from 0 to i to get the unique elements

//passes.

// [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
// [0, 1, 1, 1, 1, 2, 2, 3, 3, 4]
// [0, 1, 2, 1, 1, 2, 2, 3, 3, 4]
// [0, 1, 2, 3, 1, 2, 2, 3, 3, 4]
// [0, 1, 2, 3, 4, 2, 2, 3, 3, 4]

public class RemoveDuplicatesfromSortedArray {

	public static void main(String[] args) {

		int[] a = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };

		System.out.println(removeDuplicates(a));

	}

	public static int removeDuplicates(int[] a) {
		
		System.out.println(Arrays.toString(a));

		int i = 0;
		for (int j = 1; j < a.length; j++) {
			if (a[i] != a[j]) {
				a[i + 1] = a[j];
				i++;
			
				                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  
			System.out.println(Arrays.toString(a));
			}

		}

		return i + 1;
	}

}
