package com.dsa.dailyDigest;

import java.util.HashMap;
import java.util.Map;

public class BuildTreeFromInAndPost {
    public static void main(String[] args) {

        int[] inorder = { 9, 3, 15, 20, 7 };
        int[] postorder = { 9, 15, 7, 20, 3 };
        buildTree(inorder, postorder);

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);

    }

    public static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
            int postEnd, Map<Integer, Integer> map) {

        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postEnd]);
        int inRoot = map.get(postorder[postEnd]);
        int numsLeft = inRoot - inStart;

        root.left = buildTreeHelper(inorder, inStart, inRoot - 1, postorder, postStart, postStart + numsLeft - 1, map);
        root.right = buildTreeHelper(inorder, inRoot + 1, inEnd, postorder, postStart + numsLeft, postEnd - 1, map);

        return root;

    }

}
