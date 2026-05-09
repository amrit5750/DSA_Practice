package com.dsa.sorting;

import java.util.Arrays;

// Insertion Sort Algorithm
// Time Complexity: O(n^2) in worst and average cases, O(n) in best case
// Space Complexity: O(1)
// how it works?
// It works by building a sorted array one element at a time by repeatedly taking the next element
// from the input data and inserting it into the correct position in the already sorted part of the array.

public class InsertionSort {
	
	 public static void main(String[] args) {

	        int[] a = {14, 9, 15, 12, 6, 8, 13};

	        for (int i = 1; i < a.length; i++) {
	            int j = i;

	            while (j > 0 && a[j - 1] > a[j]) {
	                int temp = a[j];
	                a[j] = a[j - 1];
	                a[j - 1] = temp;
	                j--;
	            }
	        }

	        System.out.println(Arrays.toString(a));
	    }

}
