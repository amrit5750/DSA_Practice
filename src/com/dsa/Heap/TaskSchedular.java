package com.dsa.Heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedular {

    public static void main(String[] args) {

        char[] Tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;

        System.out.println(leastInterval(Tasks, n));

    }

    public static int leastInterval(char[] tasks, int n) {

        int[] hash = new int[26];
        int time = 0;

        for (int i = 0; i < tasks.length; i++) {
            hash[tasks[i] - 'A']++;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] > 0) {
                queue.add(hash[i]);
            }
        }

        while (!queue.isEmpty()) {
            List<Integer> temp = new ArrayList<>();

            for (int i = 1; i <= n + 1; i++) {

                if (!queue.isEmpty()) {
                    int freq = queue.peek();
                    queue.poll();
                    freq--;
                    temp.add(freq);

                }

            }

            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) > 0) {
                    queue.add(temp.get(i));
                }

            }

            if (queue.isEmpty()) {
                time += temp.size();
            } else {
                time += n + 1;

            }

        }
        return time;

    }

}
