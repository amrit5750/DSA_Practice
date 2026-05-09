package com.dsa.sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {
		
		
		public static void main(String[] args) {
			
			int[] a = {14, 9, 15, 12, 6, 8, 13};
			
			InsertionSort(a,0,a.length);
			
			System.out.println(Arrays.toString(a));
		}
		
		
		
		public static void InsertionSort(int[] arr , int i,int n) {
			
			if(i>=n) {
				return;
			}
			
			int j = i;
			while(j>0 && arr[j-1] > arr[j]) {
				int temp = arr[j-1];
				arr[j-1] = arr[j];
				arr[j] = temp;
				j--;
					
			}
			
			InsertionSort(arr,i+1,n);
		}

}
