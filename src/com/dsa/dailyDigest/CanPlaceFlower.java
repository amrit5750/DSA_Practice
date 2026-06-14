package com.dsa.dailyDigest;

public class CanPlaceFlower {

    public static void main(String[] args) {

        int[] flowerbed = { 1, 0, 0, 0, 1 };
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed, n));

    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int length = flowerbed.length;

        if (n == 0) {
            return true;
        }

        for (int i = 0; i < length; i++) {
            if (flowerbed[i] == 0) {
                boolean left = (i == 0 || flowerbed[i - 1] == 0);
                boolean right = (i == length - 1 || flowerbed[i + 1] == 0);

                if (left && right) {
                    flowerbed[i] = 1; // mark planted
                    n--;

                    if (n == 0) {
                        return true;
                    }
                }
            }
        }

        return false;

    }

}
