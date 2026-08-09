package com.dsa.dailyDigest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class RemainingMethods {

    public static void main(String[] args) {

        int n = 4;
        int k = 1;
        int[][] invocations = { { 1, 2 }, { 0, 1 }, { 3, 2 } };
        System.out.println(remainingMethods(n, k, invocations));

    }

    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(i, new ArrayList<>());

        }

        int[] indegree = new int[n];
        boolean[] suspicious = new boolean[n];

        for (int[] invocation : invocations) {
            int u = invocation[0];
            int v = invocation[1];
            map.get(u).add(v);
            indegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(k);

        while (!queue.isEmpty()) {

            int currentNode = queue.poll();
            suspicious[currentNode] = true;

            for (Integer neighbour : map.get(currentNode)) {
                indegree[neighbour]--;
                if (!suspicious[neighbour]) {
                    suspicious[neighbour] = true;
                    queue.add(neighbour);

                }

            }

        }
        List<Integer> ls = new ArrayList<>();
        boolean canRemove = false;
        for (int i = 0; i < n; i++) {
            if (suspicious[i] == true && indegree[i] > 0) {
                canRemove = true;
                break;
            }

            if (!suspicious[i]) {
                ls.add(i);
            }

        }

        if (canRemove) {
            List<Integer> vec = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                vec.add(i);
            }
            return vec;

        }

        return ls;

    }

}
