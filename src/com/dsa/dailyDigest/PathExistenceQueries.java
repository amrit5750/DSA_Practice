package com.dsa.dailyDigest;

import java.util.Arrays;

public class PathExistenceQueries {

    public static void main(String[] args) {

        int n = 2;
        int[] nums = { 1, 3 };
        int maxDiff = 1;
        int[][] queries = { { 0, 0 }, { 0, 1 } };

        System.out.println(Arrays.toString(pathExistenceQueries(n, nums, maxDiff, queries)));

    }

    public static boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        boolean[] ans = new boolean[queries.length];
        int[] parent = new int[n];

        parent[0] = 0;

        for (int i = 1; i < n; i++) {
            if (Math.abs(nums[i] - nums[i - 1]) <= maxDiff) {
                parent[i] = parent[i - 1];
            } else {
                parent[i] = i;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            ans[i] = parent[u] == parent[v];
        }

        return ans;

    }

}
