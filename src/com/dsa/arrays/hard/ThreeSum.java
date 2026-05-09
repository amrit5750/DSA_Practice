package com.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//to find all unique triplets in the array which gives the sum of zero
//time complexity: O(n^2)
//space complexity: O(1)    

//how it works: sort the array, then fix one element and use two pointers to find the other two elements    
// if the sum of the three elements is less than zero, move the left pointer to the right
// if the sum is greater than zero, move the right pointer to the left
// if the sum is zero, add the triplet to the result list and move both pointers    

public class ThreeSum {

    public static void main(String[] args) {

        int[] nums = { -1, 0, 1, 2, -1, -4 };

        List<List<Integer>> triplets = getTriplets(nums);

        System.out.println(triplets);

    }

    public static List<List<Integer>> getTriplets(int[] nums) {

        List<List<Integer>> triplet = new ArrayList<>();

        Arrays.sort(nums);

        int sum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];

                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[j]);
                    tempList.add(nums[k]);
                    triplet.add(tempList);

                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }

            }

        }

        return triplet;

    }

}
