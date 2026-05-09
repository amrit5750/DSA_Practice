package com.dsa.Trees;

public class isSymetric {
    public static void main(String[] args) {

    }

    public boolean isSymmetric(TreeNode root) {
        return isSameTree(root, root);

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {

        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.right) && isSameTree(p.right, q.left);

    }

}
