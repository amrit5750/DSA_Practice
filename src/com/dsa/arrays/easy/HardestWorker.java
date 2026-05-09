package com.dsa.arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class HardestWorker {

    public static void main(String[] args) {

        int n = 10;
        int[][] logs = { { 0, 3 }, { 2, 5 }, { 0, 9 }, { 1, 15 } };
        System.out.println(hardestWorker(n, logs));

    }

    public static int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1]; // first task duration
        int employee = logs[0][0];

        for (int i = 1; i < logs.length; i++) {
            int time = logs[i][1] - logs[i - 1][1];

            // pick max time OR smaller id in case of tie
            if (time > maxTime || (time == maxTime && logs[i][0] < employee)) {
                maxTime = time;
                employee = logs[i][0];
            }
        }

        return employee;

    }

}
