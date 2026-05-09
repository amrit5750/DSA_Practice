package com.dsa.arrays.easy;

public class MinCostToMoveChips {

    public static void main(String[] args) {

        int[] position = { 1, 2, 3 };
        System.out.println(minCostToMoveChips(position));

    }

    public static int minCostToMoveChips(int[] position) {

        int evenCount = 0;
        int oddcount = 0;

        for (int j = 0; j < position.length; j++) {
            if (position[j] % 2 == 0) {
                evenCount++;
            } else {
                oddcount++;
            }
        }
        if (evenCount == position.length || oddcount == position.length) {
            return -1;
        }
        return Math.min(evenCount, oddcount);

    }

}
