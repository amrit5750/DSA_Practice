package com.dsa.dailyDigest;

import java.util.Arrays;

public class NumRescueBoats {

    public static void main(String[] args) {

        int[] people = { 3, 2, 2, 1 };
        int limit = 3;

        System.out.println(numRescueBoats(people, limit));

    }

    public static int numRescueBoats(int[] people, int limit) {

        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        int boats = 0;
        while (left <= right) {
            // If lightest + heaviest can share a boat
            if (people[left] + people[right] <= limit) {
                left++;
            }

            // Heaviest person always boards
            right--;

            boats++;

        }
        return boats;

    }

}
