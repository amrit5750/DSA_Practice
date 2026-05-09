package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class RightView {

    public static void main(String[] args) {

    }

    public static List<Integer> rightSideView(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        getRightSide(root, 0, ls);
        return ls;

    }

    public static void getRightSide(TreeNode node, int level, List<Integer> ls) {

        if (node == null) {
            return;
        }

        if (ls.size() == level) {
            ls.add(node.val);
        }

        getRightSide(node.right, level + 1, ls);
        getRightSide(node.left, level + 1, ls);
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
