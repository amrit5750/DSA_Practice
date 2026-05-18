package com.dsa.Trees.BST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RecoverBST {

    int index = 0;

    public static void main(String[] args) {

    }

    public void recoverTree(TreeNode root) {
        List<Integer> ls = getInorder(root);
        Collections.sort(ls);
        RecoverTree(root, ls);
    }

    public void RecoverTree(TreeNode root, List<Integer> ls) {

        if (root == null) {
            return;
        }

        RecoverTree(root.left, ls);
        root.val = ls.get(index++);
        RecoverTree(root.right, ls);

    }

    public static List<Integer> getInorder(TreeNode root) {
        List<Integer> ls = new ArrayList<>();

        if (root == null) {
            return ls;
        }

        ls.addAll(getInorder(root.left));
        ls.add(root.val);
        ls.addAll(getInorder(root.right));

        return ls;

    }

}
