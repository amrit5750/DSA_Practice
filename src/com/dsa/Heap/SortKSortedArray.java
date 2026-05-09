package com.dsa.Heap;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SortKSortedArray {
    public static void main(String[] args) {

        int[] arr = { 6, 5, 3, 2, 8, 10, 9 };
        int k = 3;
        System.out.println(sortArray(arr, k));
    }

    public static List<Integer> sortArray(int[] arr, int k) {

        List<Integer> ls = new ArrayList<>();

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i <= k; i++) {
            queue.add(arr[i]);
        }

        for (int i = k + 1; i < arr.length; i++) {
            ls.add(queue.poll());
            queue.add(arr[i]);
        }

        while (!queue.isEmpty()) {
            ls.add(queue.poll());
        }
        return ls;
    }

}
