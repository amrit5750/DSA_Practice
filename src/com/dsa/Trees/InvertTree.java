package com.dsa.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {

    public static void main(String[] args) {

    }

    public static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode current = q.poll();
            TreeNode Temp = current.left;
            current.left = current.right;
            current.right = Temp;

            if (current.left != null) {
                q.add(current.left);

            }
            if (current.right != null) {
                q.add(current.right);
            }
        }
        return root;
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
