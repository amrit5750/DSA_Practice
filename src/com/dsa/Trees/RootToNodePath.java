package com.dsa.Trees;

import java.util.ArrayList;
import java.util.List;

public class RootToNodePath {

    public static void main(String[] args) {

    }

    public static List<Integer> allRootToLeaf(TreeNode root) {

        List<Integer> ls = new ArrayList<>();
        allRootToLeafHelper(root, ls, 5);
        return ls;
    }

    public static boolean allRootToLeafHelper(TreeNode root, List<Integer> ls, int x) {

        if (root == null) {
            return false;
        }
        ls.add(root.data);
        if (root.data == x) {
            return true;
        }

        if (allRootToLeafHelper(root.left, ls, x) || allRootToLeafHelper(root.right, ls, x)) {
            return true;
        }

        ls.remove(ls.size() - 1);
        return false;
    }

}

class TreeNode {

    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
}