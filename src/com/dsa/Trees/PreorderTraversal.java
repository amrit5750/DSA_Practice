package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public static void main(String[] args) {

    }

    public static List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        if (root == null) {
            return ls;
        }

        ls.add(root.val);
        ls.addAll(preorderTraversal(root.left));
        ls.addAll(preorderTraversal(root.right));
        return ls;

    }

}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;

    }

    TreeNode(int val) {
        this.val = val;

    }
}
