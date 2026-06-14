package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FindLadderTwo {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";
        List<String> ls = new ArrayList<>();
        ls.add("hot");
        ls.add("dot");
        ls.add("dog");
        ls.add("lot");
        ls.add("cog");

        System.out.println(findLadders(beginWord, endWord, ls));

    }

    private static void dfs(
            String word,
            String beginWord,
            Map<String, List<String>> parents,
            List<String> path,
            List<List<String>> result) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            result.add(temp);
            return;
        }

        if (!parents.containsKey(word)) {
            return;
        }

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent,
                    beginWord,
                    parents,
                    path,
                    result);

            path.remove(path.size() - 1);
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        // Set<String> set = new HashSet<>(wordList);
        // Queue<List<String>> queue = new LinkedList<>();
        // ArrayList<String> ls = new ArrayList<>();
        // ls.add(beginWord);
        // queue.add(ls);
        // Set<String> usedOnLebvel = new HashSet<>();
        // usedOnLebvel.add(beginWord);
        // int level = 0;
        // List<List<String>> ans = new ArrayList<>();
        // while (!queue.isEmpty()) {
        // List<String> vec = queue.poll();

        // if (vec.size() > level) {
        // level = vec.size();
        // for (String used : usedOnLebvel) {
        // set.remove(used);
        // }
        // usedOnLebvel.clear();
        // }

        // if (!ans.isEmpty() && vec.size() > ans.get(0).size()) {
        // break;
        // }

        // String word = vec.get(vec.size() - 1);

        // if (word.equals(endWord)) {
        // if (ans.isEmpty()) {
        // ans.add(new ArrayList<>(vec));
        // } else if (ans.get(0).size() == vec.size()) {
        // ans.add(new ArrayList<>(vec));
        // }
        // }

        // char[] wordArr = word.toCharArray();
        // for (int i = 0; i < wordArr.length; i++) {
        // char original = wordArr[i];
        // for (char ch = 'a'; ch <= 'z'; ch++) {
        // if (ch == original) {
        // continue;
        // }
        // wordArr[i] = ch;
        // String newWord = new String(wordArr);

        // if (set.contains(newWord)) {
        // vec.add(newWord);
        // queue.add(new ArrayList<>(vec));
        // usedOnLebvel.add(newWord);
        // vec.remove(vec.size() - 1);
        // }

        // }
        // wordArr[i] = original;

        // }

        // }

        // return ans;

        Set<String> dict = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();

        if (!dict.contains(endWord)) {
            return result;
        }

        // child -> parents
        Map<String, List<String>> parents = new HashMap<>();

        // word -> shortest distance from beginWord
        Map<String, Integer> level = new HashMap<>();

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        level.put(beginWord, 0);

        int wordLen = beginWord.length();

        while (!q.isEmpty()) {

            String word = q.poll();
            int currLevel = level.get(word);

            char[] arr = word.toCharArray();

            for (int i = 0; i < wordLen; i++) {

                char original = arr[i];

                for (char ch = 'a'; ch <= 'z'; ch++) {

                    if (ch == original)
                        continue;

                    arr[i] = ch;
                    String nextWord = new String(arr);

                    if (!dict.contains(nextWord))
                        continue;

                    // First time visiting
                    if (!level.containsKey(nextWord)) {

                        level.put(nextWord, currLevel + 1);
                        q.offer(nextWord);

                        parents.putIfAbsent(nextWord,
                                new ArrayList<>());
                        parents.get(nextWord).add(word);
                    }

                    // Another shortest path found
                    else if (level.get(nextWord) == currLevel + 1) {

                        parents.get(nextWord).add(word);
                    }
                }

                arr[i] = original;
            }
        }

        if (!level.containsKey(endWord)) {
            return result;
        }

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord,
                beginWord,
                parents,
                path,
                result);

        return result;

    }

}
