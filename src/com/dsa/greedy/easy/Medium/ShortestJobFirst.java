package com.dsa.greedy.easy.Medium;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {

        int[] jobs = { 1, 2, 3, 4, 7 };

        System.out.println(getAverage(jobs));

    }

    public static int getAverage(int[] jobs) {

        Arrays.sort(jobs);
        int totalTime = 0;
        int wt = 0;
        for (int i = 0; i < jobs.length; i++) {
            wt += totalTime;
            System.out.println(wt);
            totalTime += jobs[i];
        }
        System.out.println(totalTime);
        return wt / jobs.length;
    }

}
