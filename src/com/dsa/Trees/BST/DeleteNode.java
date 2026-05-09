package com.dsa.Trees.BST;

public class DeleteNode {
    public static void main(String[] args) {

    }

    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        if (root.val == key) {
            return helper(root);
        }
        TreeNode dummy = root;
        while (root != null) {

            if (root.val > key) {
                if (root.left != null && root.left.val == key) {
                    root.left = helper(root.left);
                    break;
                }
                root = root.left;

            } else {
                if (root.right != null && root.right.val == key) {
                    root.right = helper(root.right);
                    break;
                }
                root = root.right;
            }
        }
        return dummy;
    }

    public static TreeNode helper(TreeNode root) {
        if (root.left == null) {
            return root.right;
        } else if (root.right == null) {
            return root.left;
        } else {

            TreeNode rightChild = root.right;
            TreeNode lastRight = getMostRight(root.left);
            lastRight.right = rightChild;
            return root.left;

        }

    }

    public static TreeNode getMostRight(TreeNode root) {

        if (root.right == null) {
            return root;
        }
        return getMostRight(root.right);
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
