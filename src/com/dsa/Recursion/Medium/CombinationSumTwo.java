package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// time complexity: O(2^n) + O(nlogn) where n is the number of candidates
// space complexity: O(k) where k is the depth of the recursion tree
// This is a backtracking problem where we explore all possible combinations of candidates to reach the target sum. We can either include the current candidate and continue searching with the same index (since we can
public class CombinationSumTwo {

    public static void main(String[] args) {

        int[] candidates = { 10, 1, 2, 7, 6, 1, 5 };
        int target = 8;
        // Output: [[2,2,3],[7]]

        System.out.println((combinationSum(candidates, target)));

    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        combinationSumHelper(candidates, target, result, new ArrayList<>(), 0);
        return result;
    }

    public static void combinationSumHelper(int[] candidates, int target, List<List<Integer>> result,
            List<Integer> current, int index) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            current.add(candidates[i]);
            combinationSumHelper(candidates, target - candidates[i], result, current, i + 1);
            current.remove(current.size() - 1);
        }
    }

}
