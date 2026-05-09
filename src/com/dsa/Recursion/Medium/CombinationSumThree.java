package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumThree {

    public static void main(String[] args) {

        System.out.println(combinationSum3(4, 1));

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {

        int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3Helper(k, n, result, new ArrayList<>(), arr, 0);
        return result;
    }

    public static void combinationSum3Helper(int k, int sum, List<List<Integer>> result, List<Integer> current,
            int[] arr, int index) {
        if (sum == 0) {
            if (!current.isEmpty() && current.size() == k) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if (sum < 0 || index == arr.length) {
            return;
        }
        current.add(arr[index]);
        combinationSum3Helper(k, sum - arr[index], result, current, arr, index + 1);
        current.remove(current.size() - 1);
        combinationSum3Helper(k, sum, result, current, arr, index + 1);
    }

}
