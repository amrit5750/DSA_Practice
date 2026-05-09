package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ls = new ArrayList<>();

        if (root == null) {
            return ls;
        }

        ls.addAll(postorderTraversal(root.left));
        ls.addAll(postorderTraversal(root.right));
        ls.add(root.val);
        return ls;

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
