package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FinishTime {

    public static void main(String[] args) {

        int n = 3;
        int[][] edges = { { 0, 1 }, { 1, 2 } };
        int[] baseTime = { 9, 5, 3 };
        System.out.println(finishTime(n, edges, baseTime));
    }

    public static long finishTime(int n, int[][] edges, int[] baseTime) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] dp = new long[n];

        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());
        }

        for (int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }

        dfs(0, map, dp, baseTime);
        return dp[0];

    }

    static void dfs(int u, Map<Integer, List<Integer>> map, long[] dp, int[] baseTime) {

        if (map.get(u).size() == 0) {
            dp[u] = baseTime[u];
            return;
        }

        long mn = Long.MAX_VALUE;
        long mx = Long.MIN_VALUE;

        for (int child : map.get(u)) {
            dfs(child, map, dp, baseTime);
            mn = Math.min(mn, dp[child]);
            mx = Math.max(mx, dp[child]);
        }

        dp[u] = 2 * mx - mn + baseTime[u];

    }

}
