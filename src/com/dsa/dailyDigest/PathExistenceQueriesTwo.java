package com.dsa.dailyDigest;

public class PathExistenceQueriesTwo {

    public static void main(String[] args) {

        int n = 5;
        int[] nums = { 1, 8, 3, 4, 2 };
        int maxDiff = 3;
        int[][] queries = { { 0, 3 }, { 2, 4 } };
        System.out.println(pathExistenceQueries(n, nums, maxDiff, queries));

    }

    public static int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {

        int[] ans = new int[queries.length];

        int[] parent = new int[n];

        parent[0] =0;

        for (int i = 1; i < n; i++) {
            if(nums)
            
        }


        return ans;

    }

}
