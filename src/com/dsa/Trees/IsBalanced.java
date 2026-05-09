package com.dsa.Trees;

public class IsBalanced {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(isBalanced(root));

    }

    public static boolean isBalanced(TreeNode root) {
        return isBalancedhelper(root) == -1 ? false : true;

    }

    public static int isBalancedhelper(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int leftHeight = isBalancedhelper(root.left);
        if (leftHeight == -1) {
            return -1;
        }

        int rightHeight = isBalancedhelper(root.right);
        if (rightHeight == -1) {
            return -1;
        }

        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        return 1 + Math.max(leftHeight, rightHeight);

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
