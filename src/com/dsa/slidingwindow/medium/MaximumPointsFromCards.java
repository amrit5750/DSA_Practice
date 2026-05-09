package com.dsa.slidingwindow.medium;

public class MaximumPointsFromCards {

    public static void main(String[] args) {

        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;

        System.out.println(maxScore(cardPoints, k));

    }

    public static int maxScore(int[] cardPoints, int k) {

        int points = 0;

        for (int i = 0; i < k; i++) {
            points += cardPoints[i];
        }

        int maxpoints = points;

        for (int i = 0; i < k; i++) {

            points -= cardPoints[k - 1 - i];
            points += cardPoints[cardPoints.length - 1 - i];

            maxpoints = Math.max(maxpoints, points);

        }
        return maxpoints;

    }

}
