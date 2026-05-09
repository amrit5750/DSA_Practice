package com.dsa.arrays.easy;

import java.util.Arrays;

//to find second largest and second smallest element in an array
//Time Complexity: O(n)
//Space Complexity: O(1)	

public class FindSecondLargestandSecondSmallest {

	public static void main(String[] args) {

		int[] a = { 1, 2, 4, 7, 7, 5 };

		System.out.println(Arrays.toString(findelements(a)));

	}

	public static int[] findelements(int[] arr) {

		int[] res = new int[2];

		if (arr.length <= 1) {
			res[0] = -1;
			res[1] = -1;
			return res;
		}

		int fistMin = Integer.MAX_VALUE;
		int firstMax = Integer.MIN_VALUE;

		int secondMin = Integer.MAX_VALUE;
		int secondMax = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {

			firstMax = Math.max(firstMax, arr[i]);
			fistMin = Math.min(fistMin, arr[i]);

		}

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] < secondMin && arr[i] != fistMin) {
				secondMin = arr[i];

			}

			if (arr[i] > secondMax && arr[i] != firstMax) {
				secondMax = arr[i];
			}

		}

		res[0] = secondMin;
		res[1] = secondMax;

		return res;

	}

}
