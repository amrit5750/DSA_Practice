package com.dsa.Tries;

public class TrieImplTwo {

    Node root;

    TrieImplTwo() {
        root = new Node();
    }

    public void insert(String string) {
        Node node = root;
        for (int i = 0; i < string.length(); i++) {
            if (!node.containsKey(string.charAt(i))) {
                node.put(string.charAt(i), new Node());
            }
            node = node.get(string.charAt(i));
            node.incrementPrefix();

        }
        node.incrementEnd();

    }

    public int countWordsEqualString(String string) {
        Node node = root;
        for (int i = 0; i < string.length(); i++) {
            if (node.containsKey(string.charAt(i))) {
                node = node.get(string.charAt(i));

            } else {
                return 0;
            }

        }

        return node.getEnd();

    }

    public int countWordsStartsWith(String string) {
        Node node = root;

        for (int i = 0; i < string.length(); i++) {
            if (node.containsKey(string.charAt(i))) {
                node = node.get(string.charAt(i));
            } else {
                return 0;
            }

        }
        return node.getPrefix();

    }

    public void Erase(String word) {
        if (countWordsEqualString(word) == 0)
            return;

        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                node.reducePrefix();
            } else {
                return;
            }

        }

        node.deleteEnd();

    }

}

class Node {

    Node[] links = new Node[26];
    int countEndWith = 0;
    int countPrefix = 0;

    Node() {

    }

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    void incrementEnd() {
        countEndWith++;
    }

    void incrementPrefix() {
        countPrefix++;
    }

    void deleteEnd() {
        countEndWith--;
    }

    void reducePrefix() {
        countPrefix--;
    }

    int getEnd() {
        return countEndWith;
    }

    int getPrefix() {
        return countPrefix;
    }

}
