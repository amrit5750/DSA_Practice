package com.dsa.Trees;

public class ChangeTree {
    public static void main(String[] args) {

    }

    public static void changeTree(TreeNode node) {

        if (node == null) {
            return;
        }

        int child = 0;

        if (node.left != null) {
            child += node.left.val;
        }
        if (node.right != null) {
            child += node.right.val;
        }

        if (child >= node.val) {
            node.val = child;
        } else {
            if (node.left != null) {
                node.left.val = node.val;
            } else if (node.right != null) {
                node.right.val = node.val;
            }
        }

        changeTree(node.left);
        changeTree(node.right);

        int total = 0;
        if (node.left != null) {
            total += node.left.val;

        }
        if (node.right != null) {
            total += node.right.val;

        }

        if (node.left != null && node.right != null) {
            node.val = total;
        }

    }

}
