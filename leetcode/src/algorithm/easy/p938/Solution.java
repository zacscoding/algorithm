package algorithm.easy.p938;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/range-sum-of-bst/
 */
public class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // return solveByDFS(root, low, high);
        return solveByBFS(root, low, high);
    }

    public int solveByDFS(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        int sum = 0;

        if (root.val >= low && root.val <= high) {
            sum += root.val;
        }

        if (root.val < high && root.right != null) {
            sum += solveByDFS(root.right, low, high);
        }
        if (root.val > low && root.left != null) {
            sum += solveByDFS(root.left, low, high);
        }

        return sum;
    }

    public int solveByBFS(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int sum = 0;

        while (!que.isEmpty()) {
            TreeNode node = que.poll();
            if (node.val >= low && node.val <= high) {
                sum += node.val;
            }

            if (node.val < high && node.right != null) {
                que.offer(node.right);
            }
            if (node.val > low && node.left != null) {
                que.offer(node.left);
            }
        }

        return sum;
    }

}