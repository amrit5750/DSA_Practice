package com.dsa.sorting;

import java.util.Arrays;


//merge sort algorithm
//time complexity: O(n log n)
//space complexity: O(n)
//Divide and Conquer algorithm

public class MergeSort {

	public static void main(String[] args) {

		int[] a = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };

		int low = 0;
		int high = a.length - 1;

		mergesort(a, low, high);

		System.out.println(Arrays.toString(a));

	}

	public static void merge(int[] arr, int low, int mid, int high) {

		// low to mid
		// mid+1 to high

		int temp[] = new int[arr.length];
		int k = 0;

		int left = low;
		int right = mid + 1;

		while (left <= mid && right <= high) {

			if (arr[left] <= arr[right]) {
				temp[k] = arr[left];
				k++;
				left++;
			} else {
				temp[k] = arr[right];
				k++;
				right++;
			}
		}

		while (left <= mid) {
			temp[k] = arr[left];
			left++;
			k++;
		}

		while (right <= high) {
			temp[k] = arr[right];
			right++;
			k++;
		}

		for (int i = low; i <= high; i++) {
			arr[i] = temp[i - low];
		}

	}

	public static void mergesort(int[] arr, int low, int high) {

		if (low >= high) {
			return;
		}

		int mid = (low + high) / 2;
		mergesort(arr, low, mid);
		mergesort(arr, mid + 1, high);
		merge(arr, low, mid, high);
	}

}
