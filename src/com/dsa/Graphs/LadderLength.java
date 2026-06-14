package com.dsa.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LadderLength {
    public static void main(String[] args) {

        String beginWord = "hit";
        String endWord = "cog";

        List<String> ls = new ArrayList<>();
        ls.add("hot");
        ls.add("dot");
        ls.add("dog");
        ls.add("lot");
        ls.add("log");
        ls.add("cog");

        System.out.println(ladderLength(beginWord, endWord, ls));

    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> queue = new LinkedList<>();

        if (!set.contains(endWord))
            return 0;

        queue.add(new Pair(beginWord, 1));

        set.remove(beginWord);
        while (!queue.isEmpty()) {
            Pair current = queue.poll();

            char[] str = current.str.toCharArray();
            for (int i = 0; i < str.length; i++) {
                char original = str[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    str[i] = ch;
                    String newWord = new String(str);
                    if (set.contains(newWord)) {
                        if (newWord.equals(endWord)) {
                            return current.seq + 1;
                        }
                        queue.add(new Pair(newWord, current.seq + 1));
                        set.remove(newWord);

                    }

                }
                str[i] = original;

            }

        }

        return 0;

    }

}

class Pair {
    String str;
    int seq;

    public Pair(String str, int seq) {
        this.str = str;
        this.seq = seq;
    }

}
