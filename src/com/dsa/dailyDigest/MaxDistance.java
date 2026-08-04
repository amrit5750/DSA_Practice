package com.dsa.dailyDigest;

import java.util.Arrays;

public class MaxDistance {

    public static void main(String[] args) {
        int[] position = { 1, 2, 3, 4, 7 };
        int m = 3;
        System.out.println(maxDistance(position, m));

    }

    public static boolean canBallsPlace(int mid, int[] positions, int balls) {

        int prev = positions[0];
        int count = 1;
        for (int i = 1; i < positions.length; i++) {
            int current = positions[i];
            if (current - prev >= mid) {
                count++;
                prev = current;
            }
            if (count == balls) {
                break;
            }
        }
        return count == balls;
    }

    public static int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int ans = 0;
        int n = position.length;

        int minforce = 1;
        int maxforce = position[n - 1] - position[0];

        while (minforce <= maxforce) {
            int mid = minforce + (maxforce - minforce) / 2;

            if (canBallsPlace(mid, position, m)) {
                ans = mid;
                minforce = mid + 1;
            } else {
                maxforce = mid - 1;
            }

        }
        return ans;

    }

}
