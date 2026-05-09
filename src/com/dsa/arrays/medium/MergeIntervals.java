package com.dsa.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//LeetCode Problem 56. Merge Intervals
//time complexity: O(n log n)
//space complexity: O(n)
//how it works:
//sort the intervals based on the start time
//initialize a list to store the merged intervals
//iterate through the intervals and compare the current interval with the last merged interval
//if they overlap, merge them by updating the end time of the last merged interval
//if they don't overlap, add the current interval to the merged intervals list
//finally, convert the merged intervals list to an array and return it      
public class MergeIntervals {

    public static void main(String[] args) {

        int[][] intervals = { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } };

        System.out.println(Arrays.deepToString(MergeInterval(intervals)));

    }

    public static int[][] MergeInterval(int[][] intervals) {

        List<int[]> mergedIntervalsList = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[] currentInerval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {

            if (currentInerval[1] >= intervals[i][0]) {
                currentInerval[1] = Math.max(currentInerval[1], intervals[i][1]);
            } else {
                mergedIntervalsList.add(currentInerval);
                currentInerval = intervals[i];

            }
        }
        mergedIntervalsList.add(currentInerval);

        return mergedIntervalsList.toArray(new int[mergedIntervalsList.size()][]);

    }

}
