package com.dsa.arrays.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//to find all unique quadruplets in the array which gives the sum of target
//time complexity: O(n^3)
//space complexity: O(1)
//how it works: sort the array, then fix two elements and use two pointers to find the other two elements
// if the sum of the four elements is less than target, move the left pointer to the right
// if the sum is greater than target, move the right pointer to the left
// if the sum is equal to target, add the quadruplet to the result list and move both pointers

public class FourSum {

    public static void main(String[] args) {
        int[] nums = { 1, 0, -1, 0, -2, 2 };

        System.out.println(foursets(nums, 0));

    }

    public static List<List<Integer>> foursets(int[] nums, int target) {

        List<List<Integer>> fourSets = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {

            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int k = j + 1;
                int l = nums.length - 1;

                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];

                    if (sum == target) {
                        List<Integer> fourSet = new ArrayList<>();
                        fourSet.addAll(Arrays.asList(
                                nums[i], nums[j], nums[k], nums[l]));
                        l--;
                        k++;
                        fourSets.add(fourSet);
                        l--;
                        k++;

                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }

                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }

                    } else if (sum < target) {
                        k++;
                    } else {
                        l--;
                    }

                }

            }

        }

        return fourSets;

    }

}
