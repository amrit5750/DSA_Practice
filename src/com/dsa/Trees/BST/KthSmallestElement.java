package com.dsa.Trees.BST;

public class KthSmallestElement {
    int count = 0;
    int ans = 0;

    public static void main(String[] args) {

    }

    public int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root, k);
        return ans;
    }

    public void kthSmallestHelper(TreeNode root, int k) {

        if (root == null) {
            return;
        }

        kthSmallestHelper(root.left, k);

        count++;

        if (count == k) {
            ans = root.val;
            return;
        }

        kthSmallestHelper(root.right, k);
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
