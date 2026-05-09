package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }

        ls.addAll(inorderTraversal(root.left));
        ls.add(root.val);
        ls.addAll(inorderTraversal(root.right));
        return ls;

    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;

    }

}
