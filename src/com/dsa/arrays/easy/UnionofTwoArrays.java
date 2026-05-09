package com.dsa.arrays.easy;

import java.util.ArrayList;
import java.util.List;

//Union of Two Sorted Arrays
//time complexity: O(n + m)
//space complexity: O(n + m)
//how it works:
//use two pointers i and j to traverse both arrays
//compare arr1[i] and arr2[j]
//if arr1[i] < arr2[j], add arr1[i] to union and
//increment i
//if arr2[j] < arr1[i], add arr2[j] to union and
//increment j
//if arr1[i] == arr2[j], add either arr1[i] or arr2[j] to union and
//increment both i and j
//after the loop, add remaining elements of arr1 or arr2 to union

//other approach is to use set to store the elements of both arrays and then convert the set to list
//treeset can be used to store the elements in sorted order
//but it will increase the time complexity to O(n log n + m log m)
//treemap can also be used to store the elements in sorted order with frequency
//but it will also increase the time complexity to O(n log n + m log m)		
public class UnionofTwoArrays {

	public static void main(String[] args) {

		int arr1[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int arr2[] = { 2, 3, 4, 4, 5, 11, 12 };

		int n = arr1.length;
		int m = arr2.length;
		int i = 0;
		int j = 0;

		List<Integer> union = new ArrayList<Integer>();

		while (i < n && j < m) {
			if (arr1[i] < arr2[j]) {
				if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
					union.add(arr1[i]);

				}
				i++;
			}

			else if (arr2[j] < arr1[i]) {
				if (union.isEmpty() || union.get(union.size() - 1) != arr1[j]) {
					union.add(arr2[j]);

				}
				j++;
			} else {
				if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
					union.add(arr1[i]);

				}
				i++;
				j++;
			}
		}

		while (i < n) {
			if (union.isEmpty() || union.get(union.size() - 1) != arr1[i]) {
				union.add(arr1[i]);

			}
			i++;
		}

		while (j < m) {
			if (union.isEmpty() || union.get(union.size() - 1) != arr1[j]) {
				union.add(arr2[j]);

			}
			j++;
		}

		union.stream().forEach(a -> System.out.println(a));

	}

}
