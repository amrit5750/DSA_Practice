package com.dsa.Trees;

public class Diameter {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(diameterOfBinaryTree(root));

    }

    public static int diameterOfBinaryTree(TreeNode root) {
        int[] diameter = new int[1];
        diameterOfBinaryTreeHelper(root, diameter);

        return diameter[0];

    }

    public static int diameterOfBinaryTreeHelper(TreeNode root, int[] diameter) {

        if (root == null) {
            return 0;
        }
        int left = diameterOfBinaryTreeHelper(root.left, diameter);
        int right = diameterOfBinaryTreeHelper(root.right, diameter);
        diameter[0] = Math.max(left + right, diameter[0]);
        return 1 + Math.max(left, right);

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
