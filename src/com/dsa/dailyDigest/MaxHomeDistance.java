package com.dsa.dailyDigest;

public class MaxHomeDistance {

    public static void main(String[] args) {

        int[] colors = { 0, 1 };
        System.out.println(maxDistance(colors));

    }

    public static int maxDistance(int[] colors) {

        int result = Integer.MIN_VALUE;

        for (int i = 0; i < colors.length; i++) {
            for (int j = colors.length - 1; j > i; j--) {
                if (colors[i] != colors[j]) {
                    result = Math.max(result, j - i);
                }

            }

        }

        return result;

    }

}
