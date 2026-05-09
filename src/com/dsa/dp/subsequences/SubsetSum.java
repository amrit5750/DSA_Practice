package com.dsa.dp.subsequences;

public class SubsetSum {

    public static void main(String[] args) {

        int[] arr = { 1, 2, 7, 6 };
        int target = 6;

        System.out.println(isSubsetSum(arr, target));

    }

    public static boolean isSubsetSum(int[] arr, int target) {

        return isSubsetSumHelper(arr, target, 0);

    }

    public static boolean isSubsetSumHelper(int[] arr, int target,
            int index) {

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }

        if (index >= arr.length) {
            return false;
        }

        boolean isTake = isSubsetSumHelper(arr, target - arr[index], index + 1);
        boolean notTake = isSubsetSumHelper(arr, target, index + 1);

        return isTake || notTake;

    }
}
