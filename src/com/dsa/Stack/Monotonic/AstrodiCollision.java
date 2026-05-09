package com.dsa.Stack.Monotonic;

import java.util.Arrays;
import java.util.Stack;

public class AstrodiCollision {

    public static void main(String[] args) {

        int[] asteroids = { 5, 10, -5 };

        System.out.println(Arrays.toString(asteroidCollisionMine(asteroids)));

    }

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();
        for (Integer asteroid : asteroids) {
            boolean isDestroyed = false;
            while (!stack.isEmpty() && stack.peek() > 0 && asteroid < 0) {
                if (Math.abs(stack.peek()) < Math.abs(asteroid)) {
                    stack.pop();
                    continue;
                } else if (Math.abs(stack.peek()) == Math.abs(asteroid)) {
                    stack.pop();
                }
                isDestroyed = true;
                break;
            }

            if (!isDestroyed) {
                stack.push(asteroid);
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }

    public static int[] asteroidCollisionMine(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (Integer asteroid : asteroids) {

            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                while (!stack.isEmpty() && stack.peek() > 0 &&
                        stack.peek() < Math.abs(asteroid)) {
                    stack.pop();
                }

                if (!stack.isEmpty() && stack.peek() == Math.abs(asteroid)) {
                    stack.pop();
                } else if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);
                }
            }
        }

        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return result;

    }

}
