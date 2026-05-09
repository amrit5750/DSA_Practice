package com.dsa.greedy.easy.Medium;

import java.util.Arrays;

public class JobSequenceProblem {
    public static void main(String[] args) {

        int[][] jobs = { { 1, 4, 20 }, { 2, 1, 10 }, { 3, 1, 40 }, { 4, 1, 30 } };
        System.out.println(Arrays.toString(getNumberOfJobs(jobs)));
    }

    public static int[] getNumberOfJobs(int[][] jobs) {

        Arrays.sort(jobs, (a, b) -> Integer.compare(b[2], a[2]));
        int maxDeadLine = 0;
        int profit = 0;
        int jobsCount = 0;
        for (int i = 0; i < jobs.length; i++) {
            maxDeadLine = Math.max(maxDeadLine, jobs[i][1]);
        }
        int[] hash = new int[maxDeadLine + 1];
        for (int i = 0; i < jobs.length; i++) {
            for (int j = jobs[i][1]; j > 0; j--) {
                if (hash[j] == 0) {
                    jobsCount++;
                    profit += jobs[i][2];
                    hash[j] = jobs[i][1];
                    break;
                }
            }
        }
        return new int[] { jobsCount, profit };
    }
}
