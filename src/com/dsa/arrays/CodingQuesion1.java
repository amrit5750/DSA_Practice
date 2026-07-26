package com.dsa.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import java.util.PriorityQueue;

public class CodingQuesion1 {

    public static void main(String[] args) {

        // int[] nums = { 1, 2, 1, 2, 1, 2, 3, 1, 3, 2 };
        // int k = 2;

        int[] nums = {

                1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 5, 5, 5, 5, 5,

                -1, -1, -1, -2, -2, -2, -2, -2, -2,

                6, 7, 8, 8, 8, 9, 9, 9, 9, 9, 9,

                10, 10, 10, 10, 10, 10, 10, 11, 11,

                100, 100, 100, 50, 50, 50, 50, 50,

                0, 0, 0, 0, 0, 0, 0, 0

        };

        int k = 5;

        System.out.println(Arrays.toString(getKMostFrequentElement(nums, k)));

    }

    public static int[] getKMostFrequentElement(int[] arr, int k) {

        Map<Integer, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            freqMap.put(arr[i], freqMap.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> freqMap.get(a) - freqMap.get(b));

        for (Integer key : freqMap.keySet()) {
            heap.add(key);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] ans = new int[k];

        int i = 0;
        while (!heap.isEmpty()) {
            ans[i] = heap.poll();
            i++;
        }
        return ans;

    }

}
