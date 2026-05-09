package com.dsa.sorting;

import java.util.Arrays;

// Bubble Sort Algorithm	
// Time Complexity: O(n^2) in all cases
// Space Complexity: O(1)

//how it works?
// It works by repeatedly swapping the adjacent elements if they are in wrong order.

//iteration 1: 46 24 13 20 9 52
//iteration 2: 24 13 20 9 46 52
//iteration 3: 13 20 9 24 46 52
//iteration 4: 13 9 20 24 46 52
//moves the largest Element to the end


public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 13, 46, 24, 52, 20, 9 };

		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;

				}

			}

		}
		
		System.out.println(Arrays.toString(arr));

	}

}
