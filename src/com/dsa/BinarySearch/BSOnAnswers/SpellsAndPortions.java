package com.dsa.BinarySearch.BSOnAnswers;

import java.util.Arrays;

public class SpellsAndPortions {

    public static void main(String[] args) {
        int[] spells = { 3, 1, 2 };
        int[] portions = { 8, 5, 8 };

        System.out.println(Arrays.toString(successfulPairs(spells, portions, 16)));
    }

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {

        int[] ans = new int[spells.length];
        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {

            ans[i] = getLargerElements(spells[i], potions, success);

        }

        return ans;

    }

    public static int getLargerElements(int spell, int[] portions, long success) {

        int low = 0;
        int high = portions.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) portions[mid] * spell >= success) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return portions.length - low;

    }

}
