package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SolveQueries {

    public static void main(String[] args) {

        int[] nums = { 1, 3, 1, 4, 1, 3, 2 };
        int[] queries = { 0, 3, 5 };
        System.out.println(solveQueries(nums, queries));

    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {

        int n = nums.length;

        Map<Integer, List<Integer>> mp = new HashMap<>();

        // store indices
        for (int i = 0; i < n; i++) {
            mp.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for (int qi : queries) { // O(Q)
            int element = nums[qi];
            List<Integer> vec = mp.get(element);

            int sz = vec.size();

            // no more occurrence
            if (sz == 1) {
                result.add(-1);
                continue;
            }

            int pos = Collections.binarySearch(vec, qi);
            int res = Integer.MAX_VALUE;

            // Right neighbor
            int right = vec.get((pos + 1) % sz);
            int d = Math.abs(qi - right);
            int circularDist = n - d;
            res = Math.min(res, Math.min(d, circularDist));

            // Left neighbor
            int left = vec.get((pos - 1 + sz) % sz);
            d = Math.abs(qi - left);
            circularDist = n - d;
            res = Math.min(res, Math.min(d, circularDist));

            result.add(res);
        }

        return result;

    }

}
