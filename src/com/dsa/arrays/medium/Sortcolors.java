package com.dsa.arrays.medium;

import java.util.Arrays;

//time complexity : O(n)
//space complexity : O(1)		
//how it works?
// It uses three pointers low, mid, high
// low and mid starts from 0 and high starts from end of the array		
// if the element at low is 0, swap it with mid and increment both low and mid
// if the element at low is 1, increment mid
// if the element at low is 2, swap it with high and decrement high	

public class Sortcolors {
	
	public static void main(String[] args) {
		
		int[] a = {2,0,2,1,1,0};
		
		sortColors(a);
		
		System.out.println(Arrays.toString(a));
		
		
		
	}
	
	public static void sortColors(int[] nums ) {
		
		int low =  0 ; int mid = 0;
		int high = nums.length-1;
		
		while(mid<=high) {
			
			if(nums[low] == 0) {
				int temp = nums[low];
				nums[low] = nums[mid];
				nums[mid] = temp;
				low++;
				mid++;
				
			}
			
			else if(nums[low] == 1) {
				mid++;
				
			}
			
			else {
				int temp = nums[mid];
				nums[mid] = nums[high];
				nums[high] = temp;
				high--;                                                                                                                                                                                                                                          
				
			}
			
			
		}
		

		
		
		
		
		
	}

}
