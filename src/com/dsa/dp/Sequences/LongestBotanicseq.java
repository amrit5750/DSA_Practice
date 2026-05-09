package com.dsa.dp.Sequences;

public class LongestBotanicseq {
    public static void main(String[] args) {
        int[] arr = { 5, 1, 4, 2, 3, 6, 8, 7 };
        System.out.println(LongestBitonicSequence(arr));

    }

    public static int LongestBitonicSequence(int[] arr) {

        return LongestBitonicSequenceHelper(arr);
    }

    public static int LongestBitonicSequenceHelper(int[] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            int lis = lis(i, arr);
            int lds = lds(i, arr);

            max = Math.max(lis, lds);

        }
        return max;

    }

    public static int lis(int i, int[] arr) {

        int max = 1;
        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                max = Math.max(max, 1 + lis(j, arr));
            }
        }
        return max;
    }

    public static int lds(int i, int[] arr) {

        int max = 1;
        for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[i]) {
                max = Math.max(max, 1 + lds(j, arr));
            }
        }
        return max;

    }

}
