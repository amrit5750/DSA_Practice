package com.dsa.BinarySearch.BS1DArray;

public class SqrtX {

    public static void main(String[] args) {

        System.out.println(mySqrt(4));

    }

    public static int mySqrt(int x) {

        int low = 0;
        int high = x;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((long) mid * mid > x) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return high;

    }

}
