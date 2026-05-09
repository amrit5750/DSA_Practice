package com.dsa.Heap;

import java.util.PriorityQueue;

public class ConnectSticks {

    public static void main(String[] args) {

        int[] sticks = { 2, 4, 3 };

        System.out.println(connectSticks(sticks));

    }

    public static int connectSticks(int[] sticks) {

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int cost = 0;

        for (int i = 0; i < sticks.length; i++) {
            queue.add(sticks[i]);
        }
        while (queue.size() > 1) {

            int min1 = queue.poll();
            int min2 = queue.poll();

            cost += min1 + min2;
            queue.add(min1 + min2);
        }
        return cost;

    }

}
