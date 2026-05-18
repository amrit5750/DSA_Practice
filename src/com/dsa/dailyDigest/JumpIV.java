package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.dsa.LinkedList.LinkedList;

public class JumpIV {
    public static void main(String[] args) {

        int[] arr = { 100, -23, -23, 404, 100, 23, 23, 23, 3, 404 };
        System.out.println(minJumps(arr));

    }

    public static int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        boolean[] visited = new boolean[arr.length];
        Queue<Integer> queue = new LinkedList();

        for (int i = 0; i < arr.length; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        queue.add(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int current = queue.poll();

                if (current == arr.length - 1) {
                    return steps;
                }
                int left = current - 1;
                int right = current + 1;

                if (left >= 0 && !visited[left]) {
                    queue.add(left);
                    visited[left] = true;
                }
                if (right <= arr.length - 1 && !visited[right]) {
                    queue.add(right);
                    visited[right] = true;
                }

                if (map.containsKey(arr[current])) {
                    for (Integer index : map.get(arr[current])) {
                        if (!visited[index]) {
                            queue.add(index);
                            visited[index] = true;
                        }
                    }
                    map.remove(arr[current]);

                }

            }
            steps++;
        }

        return -1;

    }

}
