package com.dsa.contest.fourSeventyeight;

import java.util.Arrays;

public class CountElementAtleastGreaterValue {

    public static void main(String[] args) {

        int[] nums = { 5, 5, 5 };
        int k = 2;

        System.out.println(countElements(nums, k));

    }

    public static int countElements(int[] nums, int k) {

        Arrays.sort(nums);
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i >= k && i <= n - k - 1) {
                count++;
            }
        }

        return count;

    }

}
