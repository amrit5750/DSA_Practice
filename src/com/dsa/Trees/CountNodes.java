package com.dsa.Trees;

public class CountNodes {

    public static void main(String[] args) {

    }

    public static int countNodes(TreeNode root) {
        return countNodesHelper(root, 0);

    }

    public static int countNodesHelper(TreeNode root, int count) {

        if (root == null) {
            return 0;
        }
        return 1 + countNodesHelper(root.left, count) + countNodesHelper(root.right, count);

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
