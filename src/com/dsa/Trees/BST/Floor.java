package com.dsa.Trees.BST;

public class Floor {

    public static void main(String[] args) {

    }

    public int floor(TreeNode root, int key) {

        int ans = 0;

        if (root == null) {
            return -1;
        }

        if (root.val == key) {
            ans = root.val;
            return ans;
        }

        if (root.val > key) {
            return floor(root.left, key);
        }
        ans = floor(root.right, key);

        return (ans <= key && ans != -1) ? ans : root.val;

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
