package com.dsa.dailyDigest;

import java.util.Arrays;

public class DefuseBomb {
    public static void main(String[] args) {

        int[] code = { 2, 4, 9, 3 };
        int k = -2;
        System.out.println(Arrays.toString(decrypt(code, k)));

    }

    public static int[] decrypt(int[] code, int k) {

        int n = code.length;

        int[] result = new int[code.length];

        if (k == 0) {
            Arrays.fill(result, 0);

        }

        if (k > 0) {
            for (int i = 0; i < result.length; i++) {
                int element = 0;
                for (int j = i + 1; j <= i + k; j++) {
                    element += code[j % result.length];
                }
                result[i] = element;

            }
        }

        if (k < 0) {
            for (int i = 0; i < result.length; i++) {
                int element = 0;
                for (int j = i - 1; j >= i + k; j--) {
                    int index = (j % n + n) % n;
                    element += code[index];
                }

                result[i] = element;

            }
        }

        return result;

    }

}
