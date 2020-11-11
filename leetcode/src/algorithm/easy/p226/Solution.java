package algorithm.easy.p226;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        // return solveByBFS(root);
        return solveByDFS(root);
    }

    public TreeNode solveByBFS(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);

        while (!deque.isEmpty()) {
            TreeNode node = deque.pollLast();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;

                deque.addLast(node.left);
                deque.addLast(node.right);
            }
        }
        return root;
    }

    public TreeNode solveByDFS(TreeNode root) {
        if (root == null) {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
                stack.push(node.left);
                stack.push(node.right);
            }
        }
        return root;
    }
}
