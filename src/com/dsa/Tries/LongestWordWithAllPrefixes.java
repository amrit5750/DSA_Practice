package com.dsa.Tries;

import java.util.Arrays;
import java.util.List;

public class LongestWordWithAllPrefixes {

    static Node root = new Node();

    public static void main(String[] args) {

        List<String> nums = Arrays.asList("n", "ni", "nin", "ninj", "ninja", "nil");
        System.out.println(completeString(nums));

    }

    public static boolean isPrefixesExists(String word) {
        Node node = root;
        boolean flag = true;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
                flag = flag & node.isEnd();
            } else {
                return false;
            }
        }

        return flag;

    }

    public static void insertWord(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setFlag();
    }

    public static String completeString(List<String> nums) {

        for (String num : nums) {
            insertWord(num);
        }

        String longest = "";

        for (int i = 0; i < nums.size(); i++) {
            if (isPrefixesExists(nums.get(i))) {
                if (nums.get(i).length() > longest.length()) {
                    longest = nums.get(i);
                } else if (nums.get(i).length() == longest.length() && nums.get(i).compareTo(longest) < 0) {
                    longest = nums.get(i);

                }

            }

        }

        return longest == "" ? "None" : longest;

    }

}

class Node {

    Node[] links = new Node[26];
    boolean flag;

    public Node() {

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

    boolean isEnd() {
        return flag;
    }

    void setFlag() {
        flag = true;
    }
}
