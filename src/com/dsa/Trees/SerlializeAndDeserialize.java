package com.dsa.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class SerlializeAndDeserialize {

    public static void main(String[] args) {

    }

    public static String serialize(TreeNode root) {

        if (root == null) {
            return "";
        }

        StringBuilder s = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {
                s.append("# ");
            } else {
                s.append(current.val).append(" ");

                // add children only for non-null node
                queue.add(current.left);
                queue.add(current.right);
            }
        }

        return s.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {

        if (data == null || data.length() == 0) {
            return null;
        }

        String[] values = data.split(" ");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNode parent = queue.poll();

            // left child
            if (!values[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;

            // right child
            if (i < values.length && !values[i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                parent.right = right;
                queue.add(right);
            }
            i++;
        }

        return root;
    }

}
