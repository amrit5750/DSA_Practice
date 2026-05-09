package com.dsa.Tries;

public class FindMaxXor {

    public static void main(String[] args) {

        int[] nums = { 3, 10, 5, 25, 2, 8 };
        System.out.println(findMaximumXOR(nums));

    }

    public static int findMaximumXOR(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            Trie.insert(nums[i]);
        }

        int answer = 0;
        for (int i = 0; i < nums.length; i++) {

            answer = Math.max(answer, Trie.find_max(nums[i]));
        }

        return answer;

    }

}

class Trie {

    private static Node root;

    public Trie() {
        root = new Node();
    }

    public static void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = ((num >> i) & 1);
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public static int find_max(int num) {
        int maxi = 0;
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = ((num >> i) & 1);
            if (node.containsKey(1 - bit)) {
                maxi = (maxi | (1 << i));
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxi;
    }
}

class Node {
    Node[] links = new Node[2];

    Node() {
    }

    public boolean containsKey(int bit) {
        return links[bit] != null;
    }

    public void put(int bit, Node node) {
        links[bit] = node;
    }

    public Node get(int bit) {
        return links[bit];
    }
}
