package com.dsa.dp.Sequences;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LongestLISPrint {

    public static void main(String[] args) {

        int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
        System.out.println(longestIncreasingSubsequence(arr));
    }

    public static List<Integer> longestIncreasingSubsequence(int[] arr) {

        List<Integer> ls = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {

            int index = Collections.binarySearch(ls, arr[i]);

            if (index < 0) {
                index = -(index + 1);
            }

            if (index == ls.size()) {
                ls.add(arr[i]);
            } else {
                ls.set(index, arr[i]);
            }

        }

        return ls;

    }

}
