package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class RobotCollision {

    public static void main(String[] args) {

        int[] positions = { 3, 5, 2, 6 };
        int[] healths = { 10, 10, 15, 12 };
        String directions = "RLRL";

        System.out.println(survivedRobotsHealths(positions, healths, directions));
    }

    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] idx = new Integer[n];

        for (int i = 0; i < n; i++) {

            idx[i] = i;
        }

        Arrays.sort(idx, (a, b) -> positions[a] - positions[b]);

        Stack<Integer> stack = new Stack<>();

        for (int i : idx) {
            if (directions.charAt(i) == 'R') {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && healths[i] > 0) {
                    int top_idx = stack.peek();
                    stack.pop();

                    if (healths[top_idx] > healths[i]) {

                        healths[top_idx]--;
                        healths[i] = 0;
                        stack.push(top_idx);
                    } else if (healths[top_idx] < healths[i]) {
                        healths[i]--;
                        healths[top_idx] = 0;
                    } else {
                        healths[top_idx] = 0;
                        healths[i] = 0;
                    }

                }

            }

        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }

        }

        return result;

    }

}
