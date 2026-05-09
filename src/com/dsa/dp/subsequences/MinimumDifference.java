package com.dsa.dp.subsequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDifference {

    public static void main(String[] args) {

        int[] nums = { 36, 36 };

        System.out.println(minimumDifference(nums));

    }

    public static List<List<Integer>> findAllSubsetsSum(int[] nums, int l, int r) {
        int len = r - l + 1;
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i <= len; i++) {
            res.add(new ArrayList<>());
        }
        for (int mask = 0; mask < (1 << len); mask++) {
            int sum = 0;
            int count = 0;

            for (int j = 0; j < len; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += nums[l + j];
                    count++;
                }
            }

            res.get(count).add(sum);
        }

        return res;
    }

    public static int minimumDifference(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for (int num : nums)
            totalSum += num;

        List<List<Integer>> left = findAllSubsetsSum(nums, 0, n / 2 - 1);
        List<List<Integer>> right = findAllSubsetsSum(nums, n / 2, n - 1);

        int target = totalSum / 2;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i <= n / 2; i++) {
            List<Integer> rList = right.get(n / 2 - i);
            Collections.sort(rList);

            for (int leftSum : left.get(i)) {
                int need = target - leftSum;

                int idx = Collections.binarySearch(rList, need);

                if (idx < 0)
                    idx = -idx - 1;

                // Check current index
                if (idx < rList.size()) {
                    int sum = leftSum + rList.get(idx);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }

                // Check previous index (important!)
                if (idx - 1 >= 0) {
                    int sum = leftSum + rList.get(idx - 1);
                    ans = Math.min(ans, Math.abs(totalSum - 2 * sum));
                }
            }
        }

        return ans;
    }

}

// public int minimumDifference(int[] nums) {
// return minSubsetSumDifference(nums, nums.length);

// int sum = Arrays.stream(nums).sum();
// Map<String, Integer> dp = new HashMap<>();
// return minimumDifferenceHelper(nums, sum, 0, 0, 0, dp);

// }
// public static int minimumDifferenceHelper(int[] nums, int totalSum, int
// currentSum,
// int index, int count,
// Map<String, Integer> dp) {

// if (count == nums.length / 2) {
// return Math.abs(totalSum - 2 * currentSum);
// }
// if (index == nums.length) {
// return Integer.MAX_VALUE;

// }

// String key = index + "|" + count + "|" + currentSum;

// if (dp.containsKey(key)) {
// return dp.get(key);
// }
// int take = minimumDifferenceHelper(nums, totalSum, currentSum + nums[index],
// index + 1, count + 1, dp);
// int skip = minimumDifferenceHelper(nums, totalSum, currentSum, index + 1,
// count, dp);
// int result = Math.min(take, skip);
// dp.put(key, result);
// return result;
// }