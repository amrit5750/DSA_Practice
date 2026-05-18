package com.dsa.Trees.BST;

import java.util.Stack;

public class BSTIterator {

    static Stack<TreeNode> stack = new Stack<>();

    public BSTIterator(TreeNode root) {
        pushAll(root);

    }

    public int next() {

        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;

    }

    public boolean hasNext() {
        return !stack.isEmpty();

    }

    public static void pushAll(TreeNode node) {

        while (node != null) {
            stack.push(node);
            node = node.left;
        }

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
