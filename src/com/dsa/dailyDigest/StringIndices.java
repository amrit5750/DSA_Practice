package com.dsa.dailyDigest;

public class StringIndices {

    static class Node {

        int index;
        Node[] links;

        public Node() {
            index = -1;
            links = new Node[26];
        }
    }

    Node root = new Node();

    // Insert word into reverse trie
    void insert(int idx, String[] wordsContainer) {

        String word = wordsContainer[idx];
        int len = word.length();

        Node node = root;

        // update root with shortest string index
        if (root.index == -1 ||
                wordsContainer[root.index].length() > len) {
            root.index = idx;
        }

        for (int j = len - 1; j >= 0; j--) {

            int ch = word.charAt(j) - 'a';

            if (node.links[ch] == null) {
                node.links[ch] = new Node();
            }

            node = node.links[ch];

            // store index of shortest word passing this node
            if (node.index == -1 ||
                    wordsContainer[node.index].length() > len) {
                node.index = idx;
            }
        }
    }

    // Search best matching suffix
    int search(String word, String[] wordsContainer) {

        Node node = root;
        int resultIdx = root.index;

        for (int i = word.length() - 1; i >= 0; i--) {

            int ch = word.charAt(i) - 'a';

            if (node.links[ch] == null) {
                return resultIdx;
            }

            node = node.links[ch];
            resultIdx = node.index;
        }

        return resultIdx;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        int m = wordsContainer.length;
        int n = wordsQuery.length;

        int[] result = new int[n];

        // build trie
        for (int i = 0; i < m; i++) {
            insert(i, wordsContainer);
        }

        // answer queries
        for (int i = 0; i < n; i++) {
            result[i] = search(wordsQuery[i], wordsContainer);
        }

        return result;
    }
}