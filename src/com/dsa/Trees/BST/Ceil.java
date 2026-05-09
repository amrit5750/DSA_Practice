package com.dsa.Trees.BST;

public class Ceil {

    public static void main(String[] args) {

    }

    public int CeilOfBST(TreeNode root, int key) {

        int ans = -1;

        if (root == null) {
            return -1;
        }

        if (root.val == key) {
            ans = root.val;
            return ans;
        }

        if (root.val > key) {
            ans = CeilOfBST(root.left, key);
            return (ans >= key && ans != -1) ? ans : root.val;

        }
        return CeilOfBST(root.right, key);
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
