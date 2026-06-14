package com.dsa.dailyDigest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MinimumMultiplications {

    static int m = 100000;

    public static void main(String[] args) {

        int[] arr = { 2, 5, 7 };
        int start = 3;
        int end = 30;
        System.out.println(minimumMultiplications(arr, start, end));

    }

    public static int minimumMultiplications(int[] arr,
            int start, int end) {

        int[] distance = new int[m];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int ele : arr) {
                int num = (node * ele) % m;

                if (distance[node] + 1 < distance[num]) {
                    distance[num] = distance[node] + 1;

                    if (num == end) {
                        return distance[num];
                    }

                    queue.add(num);
                }
            }
        }
        return -1;

    }
}

class Pair {
    int num;
    int steps;

    Pair(int num, int steps) {
        this.num = num;
        this.steps = steps;
    }

}
