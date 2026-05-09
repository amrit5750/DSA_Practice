package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinimumTotalDistance {

    public static void main(String[] args) {

        List<Integer> robot = Arrays.asList(0, 4, 6);
        int[][] factory = { { 2, 2 }, { 6, 2 } };
        System.out.println(minimumTotalDistance(robot, factory));

    }

    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {

        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> Integer.compare(a[0], b[0]));

        List<Integer> robotPositions = new ArrayList<>();

        for (int i = 0; i < factory.length; i++) {
            for (int j = 0; j < factory[i][1]; j++) {
                robotPositions.add(factory[i][0]);
            }
        }
        Long[][] dp = new Long[robot.size() + 1][robotPositions.size() + 1];
        return minimumTotalDistanceHelper(robot, robotPositions, 0, 0, robot.size(), robotPositions.size(), dp);
    }

    public static long minimumTotalDistanceHelper(List<Integer> robot, List<Integer> robotPositions, int i, int j,
            int m, int n, Long[][] dp) {

        if (i >= m) {
            return 0;
        }

        if (j >= n) {
            return Long.MAX_VALUE / 2;
        }

        if (dp[i][j] != null) {
            return dp[i][j];
        }

        long take = Math.abs(robot.get(i) - robotPositions.get(j))
                + minimumTotalDistanceHelper(robot, robotPositions, i + 1, j + 1, m, n, dp);
        long notTake = minimumTotalDistanceHelper(robot, robotPositions, i, j + 1, m, n, dp);

        return dp[i][j] = Math.min(take, notTake);
    }

}
