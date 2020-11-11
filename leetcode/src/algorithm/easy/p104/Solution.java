package algorithm.easy.p104;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        //return solveByRecursive(root);
        return solveByBFS(root);
    }

    public int solveByBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int depth = 0;

        while (!que.isEmpty()) {
            depth++;
            int repeat = que.size();
            for (int i = 0; i < repeat; i++) {
                TreeNode node = que.poll();
                if (node.left != null) {
                    que.offer(node.left);
                }
                if (node.right != null) {
                    que.offer(node.right);
                }
            }
        }
        return depth;
    }

    public int solveByRecursive(TreeNode root) {
        if (root == null) {return 0;}
        return maxDepth(root, 1);
    }

    public int maxDepth(TreeNode node, int current) {
        if (node.left == null && node.right == null) { return current; }
        int answer = current;
        if (node.left != null) {
            answer = maxDepth(node.left, current + 1);
        }
        if (node.right != null) {
            answer = Math.max(answer, maxDepth(node.right, current + 1));
        }
        return answer;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) { this.val = val; }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
