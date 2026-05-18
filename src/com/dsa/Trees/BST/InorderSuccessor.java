package com.dsa.Trees.BST;

public class InorderSuccessor {

    public static void main(String[] args) {

    }

    public TreeNode InorderSucessor(TreeNode root, TreeNode p) {

        if (root == null) {
            return null;
        }
        TreeNode successor = null;

        while (root != null) {
            if (p.val >= root.val) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }
        }
        return successor;
    }

}
