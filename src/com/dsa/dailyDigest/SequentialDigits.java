package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SequentialDigits {
    public static void main(String[] args) {

        int low = 100;
        int high = 300;
        System.out.println(sequentialDigits(low, high));

    }

    public static List<Integer> sequentialDigits(int low, int high) {

        // List<Integer> ls = new ArrayList<>();

        // Queue<Integer> queue = new LinkedList<>();

        // for (int i = 1; i <= 8; i++) {
        // queue.add(i);
        // }

        // while (!queue.isEmpty()) {
        // int front = queue.poll();

        // if (front >= low && front <= high) {
        // ls.add(front);
        // }
        // int lastDigit = front % 10;
        // if (lastDigit + 1 <= 9) {
        // queue.add(front * 10 + lastDigit + 1);
        // }
        // }
        // return ls;

        List<Integer> allPossible = List.of(12, 23, 34, 45, 56, 67, 78, 89,
                123, 234, 345, 456, 567, 678, 789,
                1234, 2345, 3456, 4567, 5678, 6789,
                12345, 23456, 34567, 45678, 56789,
                123456, 234567, 345678, 456789,
                1234567, 2345678, 3456789,
                12345678, 23456789,
                123456789);

        List<Integer> result = new ArrayList<>();

        int n = allPossible.size();

        for (int i = 0; i < n; i++) {
            if (allPossible.get(i) < low)
                continue;

            if (allPossible.get(i) > high)
                break;

            result.add(allPossible.get(i));
        }
        return result;

    }

}
