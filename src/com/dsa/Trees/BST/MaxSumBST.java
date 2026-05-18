package com.dsa.Trees.BST;

public class MaxSumBST {

    public static void main(String[] args) {

    }

    final int MIN_INDEX = 0;
    final int MAX_INDEX = 1;
    final int COUNT_INDEX = 2;

    public int largestBST(TreeNode root) {
        return largestBSTGHelper(root)[COUNT_INDEX];
    }

    int[] largestBSTGHelper(TreeNode root) {
        if (root == null) {
            return new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE, 0 };
        }

        int[] left = largestBSTGHelper(root.left);
        int[] right = largestBSTGHelper(root.right);

        if (root.val > left[MAX_INDEX] && root.val < right[MIN_INDEX]) {
            return new int[] { Math.min(left[MIN_INDEX], root.val), Math.max(root.val, right[MAX_INDEX]),
                    left[COUNT_INDEX] + right[COUNT_INDEX] + 1 };
        }

        return new int[] { Integer.MIN_VALUE, Integer.MAX_VALUE, Math.max(left[COUNT_INDEX], right[COUNT_INDEX]) };
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
