package com.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//rearrange the elements of the array such that positive and negative numbers are placed alternatively
//time complexity: O(n)
//space complexity: O(n)
//how it works: create two pointers, one for positive numbers and one for negative numbers
//traverse the array and place the elements at their respective positions in the new array
public class ReArrangeElementBySign {

    public static void main(String[] args) {

        int[] nums = { 3, 1, -2, -5, 2, -4 };

        int[] ReArrangeElementBySign = ReArrangeElementByOptimal(nums);

        System.out.println(Arrays.toString(ReArrangeElementBySign));

    }

    public static int[] ReArrangeElementByBruteForce(int[] nums) {

        int[] ReArrangeElementBySign = new int[nums.length];

        List<Integer> positivies = new ArrayList<>();
        List<Integer> negatives = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                negatives.add(nums[i]);
            } else {
                positivies.add(nums[i]);
            }
        }

        for (int i = 0; i < positivies.size(); i++) {
            ReArrangeElementBySign[i * 2] = positivies.get(i);
            ReArrangeElementBySign[i * 2 + 1] = negatives.get(i);

        }

        return ReArrangeElementBySign;

    }

    public static int[] ReArrangeElementByOptimal(int[] nums) {

        int[] ReArrangeElementBySign = new int[nums.length];

        int positivies = 0;
        int negatives = 1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] > 0) {
                ReArrangeElementBySign[positivies] = nums[i];
                positivies += 2;
            } else {
                ReArrangeElementBySign[negatives] = nums[i];
                negatives += 2;
            }

        }

        return ReArrangeElementBySign;

    }

}
