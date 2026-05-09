package com.dsa.sorting;

import java.util.Arrays;

// Selection Sort Algorithm
// Time Complexity: O(n^2) in all cases
// Space Complexity: O(1)
// how it works?
// It works by repeatedly finding the minimum element from unsorted part and putting it at the beginning

public class SelectionSort {

	public static void main(String[] args) {

		int[] a = { 1, 3, 6, 1, 2, 5, 98, 45 };

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;

			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[min]) {
					min = j;
				}
			}

			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}

		System.out.println(Arrays.toString(a));

	}

}
