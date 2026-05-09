package com.dsa.arrays.hard;

import java.util.Arrays;

public class FindRepeatingAndMissingNumber {

    public static void main(String[] args) {

        int nums[] = { 3, 5, 4, 1, 1 };

        // System.out.println(Arrays.toString(getBetterSolution(nums)));
        System.out.println(Arrays.toString(getAnsOptimal(nums)));

    }

    // how it works
    // time complexity = O(n)
    // space complexity = O(n)
    // here we are using hashing technique
    // we create a hash array of size n+1
    // then we traverse the given array and for each element we increase the count
    // in hash array
    // then we traverse the hash array and check for count 2 and 0
    public static int[] getBetterSolution(int[] nums) {

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int[] hash = new int[nums.length + 1];

        for (int i = 0; i < nums.length; i++) {

            hash[nums[i]]++;

        }

        for (int i = 0; i < hash.length; i++) {

            if (hash[i] == 2) {
                ans[0] = i;

            }
            if (hash[i] == 0) {
                ans[1] = i;
            }
        }

        return ans;
    }

    // time complexity = O(n)
    // space complexity = O(1)
    // here we are using mathematical approach
    // sum of n natural numbers = n(n+1)/2
    // sum of squares of n natural numbers = n(n+1)(2n+1)/6
    // then we calculate the sum and sum of squares of the given array
    // then we find the difference between the sum of array and sum of n natural
    // numbers
    // and the difference between the sum of squares of array and sum of squares of
    // n natural numbers
    // then we use the equations to find the repeating and missing numbers
    public static int[] getAnsOptimal(int[] nums) {

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;

        int n = nums.length;

        int sumofNaturalNumbers = n * (n + 1) / 2;
        int sumofSquares = n * (n + 1) * (2 * n + 1) / 6;

        int sumofArray = 0;
        int sumOfSquaresoFArray = 0;

        for (int i = 0; i < nums.length; i++) {
            sumofArray += nums[i];
            sumOfSquaresoFArray += nums[i] * nums[i];

        }

        int val1 = sumofArray - sumofNaturalNumbers;
        int val2 = sumOfSquaresoFArray - sumofSquares;

        int x = ((val2 / val1) + val1) / 2;
        int y = ((val2 / val1) - val1) / 2;

        ans[0] = x;
        ans[1] = y;

        return ans;

    }

    // sum of array = s
    // sum of n = sn

    // val1 = s-sn
    // val2 = s2 - s2n

    // x-y = val1;
    // x2-y2 = val2;

    // (x+y)(x-y) = val2;

    // (x+y) * val1=val2;

    // x+y = val2/va1;
    // x-y = val1;

    // x = ( (val2 / val1) + val1 ) / 2
    // y = ( (val2 / val1) - val1 ) / 2

}
