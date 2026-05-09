package com.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//to find all the leaders in the array
//time complexity: O(n)
//space complexity: O(k) where k is number of leaders in the array
//how it works: traverse the array from right to left and keep track of the maximum element seen so far
//if the current element is greater than the maximum element, it is a leader        

public class LeaderInArray {

    public static void main(String[] args) {

        int[] nums = { 16, 17, 4, 3, 5, 2 };

        Integer[] ans = getLeaders(nums);

        System.out.println(Arrays.toString(ans));

        // Output: [17, 5, 2]

    }

    public static Integer[] getLeaders(int[] nums) {

        List<Integer> leaders = new ArrayList<>();

        int max = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] > max) {
                max = nums[i];
                leaders.add(nums[i]);
            }

        }

        return leaders.stream().sorted(Collections.reverseOrder()).toArray(Integer[]::new);

    }

}
