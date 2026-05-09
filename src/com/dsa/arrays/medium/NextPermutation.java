package com.dsa.arrays.medium;

import java.util.Arrays;

//to find the next permutation of the array
//time complexity: O(n)
//space complexity: O(1)
//how it works: find the first decreasing element from the right, then find the element just
//larger than it to swap, finally reverse the elements to the right of the first element's index
public class NextPermutation {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 5, 4, 2 };

        // {1,3,5,4,2}
        // {1,4,2,3,5} output

        getNextPermutation(nums);

        System.out.println(Arrays.toString(nums));

    }

    public static void getNextPermutation(int[] nums) {

        int index = -1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[index]) {
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }

        reverse(nums, index + 1, nums.length - 1);

    }

    public static void reverse(int[] nums, int left, int right) {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;

        }

    }

}
