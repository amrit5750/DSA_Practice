package com.dsa.arrays.easy;

import java.util.Arrays;

//moveZerosToEnd	
//time complexity: O(n)
//space complexity: O(1)
//how it works:
//find the first zero in the array
//use two pointers, one to iterate through the array and the other to keep track of the position of the first zero
//when a non-zero element is found, swap it with the element at the position of the first zero
//increment the position of the first zero	
public class MoveZerosToEnd {

	public static void main(String[] args) {

		int[] a = { 0, 1, 0, 3, 12 };

		moveZerosToEnd(a);
		System.out.println(Arrays.toString(a));

	}

	public static void moveZerosToEnd(int[] a) {
		
		//find the first zero
		
		int j = -1;
		for (int i = 0; i < a.length; i++) {
			if(a[i] ==0) {
				j = i;
				break;
			}
		}
		
		if(j == -1) {
			return ;
		}
		
		for (int i = j+1; i < a.length; i++) {
			
			if(a[i] != 0) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				j++;
			}
		}
		
		

	}

}
