package com.dsa.Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TimeToBurnTree {

    public static void main(String[] args) {

    }

    public static int timeToBurnTree(TreeNode root, int start) {

        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        TreeNode StartPoint = getParents(root, parentMap, start);

        if (StartPoint == null) {

            return 0;
        }

        Map<TreeNode, Boolean> visitedMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        visitedMap.put(StartPoint, true);

        queue.offer(StartPoint);
        int time = 0;
        while (!queue.isEmpty()) {

            int size = queue.size();
            boolean burned = false;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();

                if (current.left != null && visitedMap.get(current.left) == null) {
                    queue.offer(current.left);
                    visitedMap.put(current.left, true);
                    burned = true;

                }
                if (current.right != null && visitedMap.get(current.right) == null) {
                    queue.offer(current.right);
                    visitedMap.put(current.right, true);
                    burned = true;

                }

                if (parentMap.get(current) != null && visitedMap.get(parentMap.get(current)) == null) {
                    queue.offer(parentMap.get(current));
                    visitedMap.put(parentMap.get(current), true);
                    burned = true;
                }
            }

            if (burned) {
                time++;
            }
        }

        return time;

    }

    public static TreeNode getParents(TreeNode root, Map<TreeNode, TreeNode> parentMap, int start) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        TreeNode node = new TreeNode(-1);

        while (!queue.isEmpty()) {

            TreeNode cuTreeNode = queue.poll();
            if (cuTreeNode.data == start) {
                node = cuTreeNode;
            }

            if (cuTreeNode.left != null) {
                parentMap.put(cuTreeNode.left, cuTreeNode);
                queue.offer(cuTreeNode.left);
            }
            if (cuTreeNode.right != null) {
                parentMap.put(cuTreeNode.right, cuTreeNode);
                queue.offer(cuTreeNode.right);
            }

        }

        return node;
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
