package com.dsa.arrays.medium;

import java.util.Arrays;

public class FindAllPermutaions {

    public static void main(String[] args) {

        int[] arr = { 4, 5, 2, 3, 1 };

        System.out.println(Arrays.toString(findNextPermutation(arr)));

        // 4,5,2,3,1
        // 4,5,3,2,1
        // 4,5,3,1,2

    }

    // public static List<List<Integer>> permute(int[] nums) {
    // List<List<Integer>> result = new ArrayList<>();

    // // int counter=

    // // return result;

    // }

    public static int[] findNextPermutation(int[] arr) {

        int index = -1;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i + 1] > arr[i]) {
                index = i;
                break;
            }

        }

        if (index == -1) {
            reverse(arr, 0, arr.length - 1);
            return arr;
        }

        for (int i = arr.length - 1; i > index; i--) {
            if (arr[i] > arr[index]) {
                int temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }

        }

        reverse(arr, index + 1, arr.length - 1);

        return arr;

    }

    public static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

}
