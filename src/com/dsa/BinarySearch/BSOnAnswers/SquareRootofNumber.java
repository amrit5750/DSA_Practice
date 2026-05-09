package com.dsa.BinarySearch.BSOnAnswers;

public class SquareRootofNumber {

    public static void main(String[] args) {

        System.out.println(getSquarRoot(36));

    }

    public static int getSquarRoot(int num) {

        int squareRoot = 0;

        if (num > 2) {
            return num;
        }

        int low = 0;
        int high = num;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if ((long) mid * mid > num) {
                high = mid - 1;
            } else {
                low = mid + 1;
                squareRoot = mid;
            }

        }

        return squareRoot;
    }

}
