package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

// Time Complexity: O(2^n) where n is the number of candidates
// Space Complexity: O(k) where k is the depth of the recursion tree
// This is a backtracking problem where we explore all possible combinations of candidates to reach the target sum. We can either include the current candidate and continue searching with the same index (since we can use the same candidate multiple times) or exclude it and move to the next index. We also need to handle the base cases where we either find a valid combination (target == 0) or exceed the target (target < 0) or reach the end of the candidates array (index == candidates.length).

public class CombinationSumOne {

    public static void main(String[] args) {

        int[] candidates = { 2, 5, 2, 1, 2 };
        int target = 5;
        // Output: [[2,2,3],[7]]

        System.out.println((combinationSum(candidates, target)));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        combinationSumHelper(candidates, target, result, new ArrayList<>(), 0);

        return result;
    }

    public static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result,
            List<Integer> current, int index) {

        if (target == 0) {
            if (!current.isEmpty()) {
                result.add(new ArrayList<>(current));
            }
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }
        current.add(candidates[index]);
        combinationSumHelper(candidates, target - candidates[index], result, current, index);
        current.remove(current.size() - 1);
        combinationSumHelper(candidates, target, result, current, index + 1);

    }

}
