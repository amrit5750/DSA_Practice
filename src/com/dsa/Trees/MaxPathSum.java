package com.dsa.Trees;

public class MaxPathSum {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(maxPathSum(root));
    }

    public static int maxPathSum(TreeNode root) {
        int[] sum = new int[1];
        sum[0] = Integer.MIN_VALUE;
        maxPathSumHelper(root, sum);
        return sum[0];

    }

    public static int maxPathSumHelper(TreeNode root, int[] sum) {

        if (root == null) {
            return 0;
        }

        int leftSum = Math.max(0, maxPathSumHelper(root.left, sum));
        int rightSum = Math.max(0, maxPathSumHelper(root.right, sum));
        sum[0] = Math.max(leftSum + rightSum + root.val, sum[0]);

        return root.val + Math.max(leftSum, rightSum);

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
