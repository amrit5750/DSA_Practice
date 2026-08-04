package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.HashSet;

import java.util.Set;

public class MinOperationsThree {

    public static void main(String[] args) {
        String boxes = "001011";
        System.out.println(Arrays.toString(minOperations(boxes)));
    }

    public static int[] minOperations(String boxes) {

        int n = boxes.length();
        int[] ans = new int[n];

        int balls = 0;
        int moves = 0;

        // Left to right
        for (int i = 0; i < n; i++) {
            ans[i] += moves;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            moves += balls;
        }

        balls = 0;
        moves = 0;

        // Right to left
        for (int i = n - 1; i >= 0; i--) {
            ans[i] += moves;
            if (boxes.charAt(i) == '1') {
                balls++;
            }
            moves += balls;
        }

        return ans;

    }

}
