package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.Stack;

public class Astroidcollision {

    public static void main(String[] args) {

        int[] asteroids = { 5, 10, -5 };

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));

    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++) {

            if (asteroids[i] > 0) {
                stack.push(asteroids[i]);
            } else {

                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i])) {
                    stack.pop();

                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroids[i])) {
                    stack.pop();
                }

                else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroids[i]);
                }
            }

        }

        int[] ans = new int[stack.size()];
        for (int j = stack.size() - 1; j >= 0; j--) {
            ans[j] = stack.pop();

        }

        return ans;

    }

}
