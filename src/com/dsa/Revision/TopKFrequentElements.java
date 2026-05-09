package com.dsa.Revision;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    public static void main(String[] args) {
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        System.out.println(topKFrequent(words, k));

    }

    public static List<String> topKFrequent(String[] words, int k) {

        List<String> result = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        PriorityQueue<Element> queue = new PriorityQueue<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }

        for (java.util.Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            queue.add(new Element(key, value));

            if (queue.size() > k) {
                queue.poll();
            }

        }

        while (!queue.isEmpty()) {
            result.add(queue.poll().key);

        }
        Collections.reverse(result);

        return result;

    }

}

class Element implements Comparable<Element> {

    String key;
    int val;

    public Element(String key, int val) {
        this.key = key;
        this.val = val;
    }

    @Override
    public int compareTo(Element o) {
        if (this.val == o.val) {
            return o.key.compareTo(this.key);
        }
        return this.val - o.val;
    }

}
