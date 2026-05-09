package com.dsa.dailyDigest;

import java.util.Arrays;

public record MaxWallsRobot() {

    public static void main(String[] args) {

        int[] robots = { 4 };
        int[] distance = { 3 };
        int[] walls = { 1, 10 };
        System.out.println(maxWalls(robots, distance, walls));

    }

    public static int maxWalls(int[] robots, int[] distance, int[] walls) {

        int n = distance.length;

        RoboItem[] robodist = new RoboItem[n];

        for (int i = 0; i < n; i++) {
            robodist[i] = new RoboItem(robots[i], distance[i]);
        }

        Arrays.sort(robodist, (a, b) -> Integer.compare(a.first, b.first));
        Arrays.sort(walls);

        RoboItem[] roboRange = new RoboItem[n];

        for (int i = 0; i < n; i++) {
            int pos = robodist[i].first;
            int dis = robodist[i].second;

            int leftLimit = (i == 0) ? 1 : robodist[i - 1].first + 1;
            int rightLimit = (i == n - 1) ? 1_000_000_000 : robodist[i + 1].first - 1;

            int L = Math.max(pos - dis, leftLimit);
            int R = Math.min(pos + dis, rightLimit);

            roboRange[i] = new RoboItem(L, R);

        }
        // direction = 0 ---> left else right
        Integer[][] dp = new Integer[n + 1][3];
        return solve(walls, robodist, roboRange, 0, 0, dp);

    }

    public static int solve(int[] walls, RoboItem[] robodist, RoboItem[] roboRange, int i, int PrevDirection,
            Integer[][] dp) {

        if (i == roboRange.length) {
            return 0;
        }
        if (dp[i][PrevDirection] != null) {
            return dp[i][PrevDirection];
        }

        int leftStart = roboRange[i].first;

        if (PrevDirection == 1) { // previous robot fires towards right
            leftStart = Math.max(leftStart, roboRange[i - 1].second + 1);

        }

        int leftTake = countWalls(walls, leftStart, robodist[i].first)
                + solve(walls, robodist, roboRange, i + 1, 0, dp);
        int RightTake = countWalls(walls, robodist[i].first, roboRange[i].second)
                + solve(walls, robodist, roboRange, i + 1, 1, dp);

        return dp[i][PrevDirection] = Math.max(leftTake, RightTake);

    }

    // First index where element >= target
    public static int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }

        return left;

    }

    // First index where element > target
    public static int upperBound(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }

        }
        return left;

    }

    public static int countWalls(int[] walls, int left, int right) {
        int lb = lowerBound(walls, left);
        int ub = upperBound(walls, right);
        return ub - lb; // number of elements in range [left, right]

    }

}

class RoboItem {

    int first;
    int second;

    RoboItem(int first, int second) {
        this.first = first;
        this.second = second;
    }

}
