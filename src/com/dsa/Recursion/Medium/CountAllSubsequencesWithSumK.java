package com.dsa.Recursion.Medium;

import java.util.ArrayList;
import java.util.List;

public class CountAllSubsequencesWithSumK {

    public static void main(String[] args) {

        int[] nums = { 4, 9, 2, 5, 1 };
        int k = 10;

        System.out.println(countSubsequenceWithTargetSum(nums, k));
        System.out.println(countSubsequenceWithTargetSumSeq(nums, k));

    }

    public static List<List<Integer>> countSubsequenceWithTargetSumSeq(int[] nums, int k) {

        List<List<Integer>> reList = new ArrayList<>();

        countSusequenceHelperWithSequences(nums, k, 0, new ArrayList<>(), reList);

        return reList;

    }

    public static int countSubsequenceWithTargetSum(int[] nums, int k) {

        return countSusequenceHelper(nums, k, 0);

    }

    public static int countSusequenceHelper(int[] nums, int sum, int index) {

        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || index == nums.length) {
            return 0;
        }

        return countSusequenceHelper(nums, sum - nums[index], index + 1) + countSusequenceHelper(nums, sum, index + 1);

    }

    public static void countSusequenceHelperWithSequences(int[] nums, int sum, int index, List<Integer> current,
            List<List<Integer>> result) {

        if (sum == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (sum < 0 || index == nums.length) {
            return;
        }
        current.add(nums[index]);
        countSusequenceHelperWithSequences(nums, sum - nums[index], index + 1, current, result);
        current.remove(current.size() - 1);
        countSusequenceHelperWithSequences(nums, sum, index + 1, current, result);

    }

}
