package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AlienDictinonary {
    public static void main(String[] args) {

        int N = 5;
        int K = 4;
        String[] dict = { "baa", "abcd", "abca", "cab", "cad" };
        System.out.println(findOrder(dict, N, K));

    }

    public static String findOrder(String[] dict, int N, int K) {

        List<List<Integer>> ls = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < dict.length - 1; i++) {
            String str1 = dict[i];
            String str2 = dict[i + 1];

            int len = Math.min(str1.length(), str2.length());

            for (int j = 0; j < len; j++) {
                if (str1.charAt(j) != str2.charAt(j)) {
                    ls.get(str1.charAt(j) - 'a').add(str2.charAt(j) - 'a');
                    break;
                }
            }
        }

        System.out.println(ls);

        List<Integer> ans = topologicalSort(K, ls);
        StringBuilder sBuilder = new StringBuilder();
        for (Integer integer : ans) {
            sBuilder.append((char) (integer + 'a'));

        }
        return sBuilder.toString();

    }

    public static List<Integer> topologicalSort(int k, List<List<Integer>> adj) {

        int[] indegree = new int[k];

        for (int i = 0; i < k; i++) {
            for (int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> ls = new ArrayList<>();

        while (!queue.isEmpty()) {
            int current = queue.poll();
            ls.add(current);

            for (Integer neighbour : adj.get(current)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }

            }

        }

        return ls;

    }

}
