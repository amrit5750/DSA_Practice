package com.dsa.Stack.Monotonic;

public class TrappingRainWater {

    public static void main(String[] args) {

        int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        System.out.println(trap(arr));

    }

    public static int trap(int[] height) {

        int drops = 0;

        int left = 0;
        int right = height.length - 1;
        int leftmax = 0;
        int rightmax = 0;

        while (left <= right) {
            if (height[left] <= height[right]) {
                if (leftmax <= height[left]) {
                    leftmax = height[left];
                } else {

                    drops += leftmax - height[left];
                }
                left++;

            } else {
                if (rightmax <= height[right]) {
                    rightmax = height[right];
                } else {
                    drops += rightmax - height[right];
                }
                right--;
            }

        }

        return drops;

    }

}
