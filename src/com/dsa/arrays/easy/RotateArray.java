package com.dsa.arrays.easy;

import java.util.Arrays;

//Rotate Array
//time complexity: O(n)
//space complexity: O(1)
//how it works:
//reverse the entire array
//reverse the first k elements
//reverse the remaining n-k elements
public class RotateArray {

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7 };

//		Rotate(a, 3);

		int rotations = 3;

		rotations = rotations % a.length;

		Reverse(a, 0, a.length - 1);
		Reverse(a, 0, rotations - 1);
		Reverse(a, rotations, a.length - 1);

		System.out.println(Arrays.toString(a));

	}

	public static void Rotate(int[] a, int k) {

		if (k == 0) {
			return;
		}

		int temp = a[a.length - 1];
		for (int i = a.length - 1; i > 0; i--) {
			a[i] = a[i - 1];
		}
		a[0] = temp;

		Rotate(a, k - 1);

	}

	public static void Reverse(int[] a, int start, int end) {

		while (start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++;
			end--;
		}
	}

}
