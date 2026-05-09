package com.dsa.arrays.easy;

//find the single number in an array where every element appears twice except for one
//time complexity: O(n)
//space complexity: O(1)
//how it works:
//use XOR operation, as a^a = 0 and a^0 = a
//iterate through the array and XOR all the elements
//the result will be the single number	

//this can be done using HashSet as well, but that will take O(n) space but XOR takes O(1) space.
public class SingleNumber {
	
	
	public static void main(String[] args) {
		
		int[] a = {2,2,1};
		
		int singleNumber = 0;
		
		
		for (int i = 0; i < a.length; i++) {
			singleNumber ^= a[i];
			
		}
		
		System.out.println(singleNumber);
		
	}

}
