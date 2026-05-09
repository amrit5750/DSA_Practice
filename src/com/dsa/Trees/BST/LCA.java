package com.dsa.Trees.BST;

public class LCA {

    public static void main(String[] args) {

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null) {
            return null;
        }

        int current = root.val;

        if (current < p.val && current < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (current > p.val && current > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }

        return root;

    }

}
