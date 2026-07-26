package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaximumElementAfterDecrementingAndRearranging {

    public static void main(String[] args) {

        int[] arr = { 2, 2, 1, 2, 1 };
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr));

    }

    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {

        Arrays.sort(arr);

        int max = 1;

        for (int i = 0; i < arr.length; i++) {

            if (i == 0) {
                arr[i] = 1;
            } else if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                arr[i] = arr[i - 1] + 1;

            }
            max = Math.max(max, arr[i]);
        }

        return max;

    }

}
