package com.dsa.dailyDigest;

public class RotatedDigits {
    public static void main(String[] args) {
        System.out.println(rotatedDigits(10));

    }

    public static int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if ((isGood(i))) {
                count++;
            }
        }
        return count;
    }

    public static boolean isGood(int n) {

        boolean isChanged = false;

        while (n > 0) {
            int rem = n % 10;

            if (rem == 3 || rem == 4 || rem == 7) {
                return false;
            }
            if (rem == 5 || rem == 2 || rem == 9 || rem == 6) {
                isChanged = true;
            }
            n = n / 10;
        }
        return isChanged;

    }

}
