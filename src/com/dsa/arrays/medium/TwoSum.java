package com.dsa.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Two Sum
//time complexity: O(n)
//space complexity: O(n)		
//how it works:
//use a hashmap to store the elements and their indices
//iterate through the array and for each element, check if the complement (sum - element)	
//is present in the hashmap
//if present, return the indices of the element and its complement
//if not present, add the element to the hashmap				
public class TwoSum {
	
	public static void main(String[] args) {
		
		int[]  a = {2,7,11,15};
		
		System.out.println(Arrays.toString(findTwoSum(a, 9)));
		
		
	}
	
	
	public static int[] findTwoSum(int[] arr , int sum) {
		
		int[] ans = new int[2];
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		
		for (int i = 0; i < arr.length; i++) {
			
			if(map.containsKey(sum - arr[i])) {
				ans[0] = map.get(sum - arr[i]);
				ans[1] = i;
				break;
				
			}
			else {
				map.put(arr[i],i);
			}	
		}
		
		
		return ans;
	}

}
