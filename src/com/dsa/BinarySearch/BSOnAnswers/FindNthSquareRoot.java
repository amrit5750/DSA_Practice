package com.dsa.BinarySearch.BSOnAnswers;

public class FindNthSquareRoot {

    public static void main(String[] args) {

        System.out.println(getNthRoot(4, 69));

    }

    public static int getNthRoot(int n, int m) {

        int nthRoot = -1;
        int low = 0;
        int high = m;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long ans = 1;

            for (int i = 0; i < n; i++) {
                ans = ans * mid;

                if (ans > m) {
                    break;
                }
            }

            if (ans == m) {
                return mid;
            }

            if (ans < m) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return nthRoot;

    }

}
