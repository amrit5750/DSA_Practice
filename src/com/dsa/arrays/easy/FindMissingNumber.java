package com.dsa.arrays.easy;

//find the missing number in an array
//time complexity: O(n)
//space complexity: O(1)
//how it works: 
//the sum of first n natural numbers is n*(n+1)/2
//calculate the sum of the array elements
//subtract the sum of array elements from the sum of first n natural numbers to get the missing number    
public class FindMissingNumber {
	
	public static void main(String[] args) {
		
		int[] a = {3,0,1};
		
		System.out.println(missingNumber(a));
		
	}
	
	
	public static int missingNumber(int[] nums) {

        int n = nums.length;
        int sum = n*(n+1)/2;
        int arraySum = 0;

        for(int i=0;i<nums.length;i++){
            arraySum+= nums[i];

        }
        
        return sum-arraySum;
        
    }

}
