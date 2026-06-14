package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class CreateBinaryTree {

    public static void main(String[] args) {

        int[][] descriptions = { { 20, 15, 1 }, { 20, 17, 0 }, { 50, 20, 1 }, { 50, 80, 0 }, { 80, 19, 1 } };

        System.out.println(createBinaryTree(descriptions));

    }

    public static TreeNode createBinaryTree(int[][] descriptions) {

        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int i = 0; i < descriptions.length; i++) {
            int parentVal = descriptions[i][0];
            int childVal = descriptions[i][1];
            int isleft = descriptions[i][2];

            TreeNode parent = nodes.computeIfAbsent(parentVal, TreeNode::new);
            TreeNode child = nodes.computeIfAbsent(parentVal, TreeNode::new);

            if (isleft == 1) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            children.add(childVal);
        }

        for (int val : nodes.keySet()) {
            if (!children.contains(val)) {
                return nodes.get(val);
            }

        }

        return null;

    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
