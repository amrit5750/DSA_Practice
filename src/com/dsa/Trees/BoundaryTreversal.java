package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BoundaryTreversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);

        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        System.out.println(printBoundary(root));

    }

    public static void addLeftBoundary(TreeNode node, List<Integer> ls) {
        TreeNode current = node;
        while (current != null) {
            if (!isLeaf(current)) {
                ls.add(current.val);
            }
            if (current.left != null) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

    }

    public static void addRightBoundary(TreeNode node, List<Integer> ls) {
        TreeNode current = node;
        Stack<Integer> stack = new Stack<>();
        while (current != null) {
            if (!isLeaf(current)) {
                stack.add(current.val);
            }
            if (current.right != null) {
                current = current.right;
            } else {
                current = current.left;
            }
        }

        while (!stack.isEmpty()) {
            ls.add(stack.pop());

        }

    }

    public static void addleaves(TreeNode node, List<Integer> ls) {
        if (isLeaf(node)) {
            ls.add(node.val);
            return;
        }
        if (node.left != null) {
            addleaves(node.left, ls);
        }
        if (node.right != null) {
            addleaves(node.right, ls);
        }

    }

    public static boolean isLeaf(TreeNode node) {

        if (node.left == null && node.right == null) {
            return true;
        }
        return false;

    }

    public static List<Integer> printBoundary(TreeNode node) {

        List<Integer> ls = new ArrayList<>();
        if (!isLeaf(node)) {
            ls.add(node.val);
        }
        addLeftBoundary(node.left, ls);
        addleaves(node, ls);
        addRightBoundary(node.right, ls);
        return ls;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}
