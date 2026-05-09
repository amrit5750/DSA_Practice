package com.dsa.greedy.easy.Medium;

import java.util.Arrays;

public class NonOverLappingIntervals {

    public static void main(String[] args) {

        int[][] intervals = { { 1, 2 }, { 1, 3 }, { 1, 2 } };

        System.out.println(eraseOverlapIntervals(intervals));

    }

    public static int eraseOverlapIntervals(int[][] intervals) {

        int count = 1;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        int freetime = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {

            if (intervals[i][0] >= freetime) {
                count++;
                freetime = intervals[i][1];
            }
        }
        return intervals.length - count;

    }

}
