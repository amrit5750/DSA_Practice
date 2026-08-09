package com.dsa.dailyDigest;

import java.util.Arrays;

public class BagOfTokens {
    public static void main(String[] args) {
        int[] tokens = { 200, 100 };
        int power = 150;
        System.out.println(bagOfTokensScore(tokens, power));

    }

    public static int bagOfTokensScore1(int[] tokens, int power) {

        int score = 0;
        int maxScore = 0;
        Arrays.sort(tokens);
        int i = 0;
        int j = tokens.length - 1;
        while (i <= j) {
            if (tokens[i] <= power) {
                power -= tokens[i];
                i++;
                score++;
                maxScore = Math.max(maxScore, score);
            } else if (score > 0) {

                power += tokens[j];
                score--;
                j--;

            } else {
                break;
            }

        }
        return maxScore;

    }

    public static int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int left = 0;
        int right = tokens.length - 1;
        int score = 0;
        int maxScore = 0;
        while (left <= right) { // If we can afford the cheapest token, // always play it face-up.
            if (power >= tokens[left]) {
                power -= tokens[left];
                left++;
                score++;
                maxScore = Math.max(maxScore, score);
            } // Otherwise, sacrifice one

            else if (score > 0) {
                power += tokens[right];
                right--;
                score--;
            } // Can't do anything useful anymore.
            else {
                break;
            }
        }
        return maxScore;
    }

}
