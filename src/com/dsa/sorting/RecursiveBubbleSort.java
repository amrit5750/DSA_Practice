package com.dsa.sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {

	public static void main(String[] args) {

		int[] arr = { 13, 46, 24, 52, 20, 9 };

		bubblesort(arr, arr.length);

		System.out.println(Arrays.toString(arr));

	}

	public static void bubblesort(int[] arr, int n) {

		if (n == 1) {
			return;
		}

		// OPTIMAL WAY
		boolean isSwap = false;

		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				int temp = arr[i];
				arr[i] = arr[i + 1];
				arr[i + 1] = temp;
				isSwap = true;
			}

		}

		if (!isSwap) {
			return;
		}

		bubblesort(arr, n - 1);

	}

}
