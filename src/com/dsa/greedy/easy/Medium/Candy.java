package com.dsa.greedy.easy.Medium;

public class Candy {

    public static void main(String[] args) {

        int[] ratings = { 1, 2, 2 };

        System.out.println(candy(ratings));

    }

    public static int candy(int[] ratings) {

        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        left[0] = 1;
        right[ratings.length - 1] = 1;

        for (int i = 1; i < right.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;

            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int candy = 0;

        for (int i = 0; i < right.length; i++) {
            candy += Math.max(left[i], right[i]);
        }
        return candy;
    }

    public static int candyOtimal(int[] ratings) {

        int candies = 1;
        int up = 0;
        int down = 0;
        int peek = 0;

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) {
                up++;
                peek = up;
                down = 0;
                candies += 1 + up;
            } else if (ratings[i] == ratings[i - 1]) {
                up = 0;
                down = 0;
                peek = 0;
                candies += 1;
            } else {
                up = 0;
                down++;
                candies += down;

                if (down > peek) {
                    candies++;
                }
            }
        }
        return candies;
    }

}
