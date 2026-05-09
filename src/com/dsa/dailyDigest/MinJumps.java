package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class MinJumps {

    static boolean[] isPrime;

    static void buildSieve(int maxElement) {

        isPrime = new boolean[maxElement + 1];
        Arrays.fill(isPrime, true);

        if (maxElement >= 0)
            isPrime[0] = false;
        if (maxElement >= 1)
            isPrime[1] = false;
        for (int num = 2; num * num <= maxElement; num++) {
            if (isPrime[num]) {
                for (int mutiple = num * num; mutiple <= maxElement; mutiple += num) {
                    isPrime[mutiple] = false;

                }
            }
        }
    }

    public static void main(String[] args) {

        int[] nums = { 1, 2, 4, 6 };
        System.out.println(minJumps(nums));
    }

    public static int minJumps(int[] nums) {

        Map<Integer, List<Integer>> map = new HashMap<>();

        int maxElement = 0;

        for (int i = 0; i < nums.length; i++) {
            maxElement = Math.max(maxElement, nums[i]);
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        int steps = 0;
        Set<Integer> seen = new HashSet<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        boolean[] visited = new boolean[nums.length];
        visited[0] = true;

        buildSieve(maxElement);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int i = queue.poll();
                if (i == nums.length - 1) {
                    return steps;
                }

                if (i - 1 >= 0 && !visited[i - 1]) {
                    queue.add(i - 1);
                    visited[i - 1] = true;
                }
                if (i + 1 <= nums.length - 1 && !visited[i + 1]) {
                    queue.add(i + 1);
                    visited[i + 1] = true;
                }

                if (isPrime[nums[i]] && !seen.contains(nums[i])) {

                    for (int mutiple = nums[i]; mutiple <= maxElement; mutiple += nums[i]) {
                        if (!map.containsKey(mutiple)) {
                            continue;
                        }

                        List<Integer> list = map.remove(mutiple);

                        for (Integer j : list) {
                            if (!visited[j]) {
                                queue.add(j);
                                visited[j] = true;
                            }

                        }

                    }
                }
                seen.add(nums[i]);
            }
            steps++;
        }
        return -1;
    }

}
