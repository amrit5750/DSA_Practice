package com.dsa.Tries;

public class NumberOfDistinctSubstrings {

    static Node root = new Node();

    public static void main(String[] args) {

        String str = "aba";

        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            Node node = root;
            for (int j = i; j < str.length(); j++) {
                if (!node.containsKey(str.charAt(i))) {
                    node.put(str.charAt(i), new Node());
                    count++;
                }
                node = node.get(str.charAt(i));

            }

        }

        System.out.println(count + 1);

    }

}

class Node {

    Node[] links = new Node[26];

    boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

}
