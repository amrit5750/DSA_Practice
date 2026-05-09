package com.dsa.arrays.easy;

import java.util.HashMap;
import java.util.Map;
//Longest SubArray with Sum K (Positive and Negative numbers)
//time complexity: O(n)
//space complexity: O(n)
//how it works:
//use a hashmap to store the sum and its index
//iterate through the array and keep adding the elements to the sum
//if the sum is equal to k, update the max length
//if the sum-k is present in the hashmap, update the max length
//if the sum is not present in the hashmap, add it to the hashmap with its index		

//why base case map.put(0,1)?
//if the sum is equal to k, then we need to consider the subarray from the start
//for example, if the array is [1,2,3] and k=6, then the sum is equal to k at index 2
//we need to consider the subarray from index 0 to 2, which has length 3
//if we don't add this base case, then the length will be calculated as 2-(-1)=3	

//we need to calculate the number of subarrays with sum k
// prefix sum approach -> prefix sum will be calculated and stored in map
// if prefix sum - k is present in map, then we found a subarray with sum k and we add the frequency of (prefix sum - k) to count and at the end return count.
public class LonestSubArrayWithSumKPosAndNeg {

	public static void main(String[] args) {

		int[] a = { 1, 1, 1 };

		System.out.println(numberofSubArrrays(a, 2));

	}

	public static int numberofSubArrrays(int[] arr, int k) {

		int count = 0;
		int sum = 0;

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, 1);

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (map.containsKey(sum - k)) {
				count += map.get(sum - k);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);

		}

		return count;
	}

}
