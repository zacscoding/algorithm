package algorithm.easy.p112;

public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return solve(root, 0, sum);
    }

    public boolean solve(TreeNode node, int acc, int sum) {
        // leaf
        if (node.left == null && node.right == null) {
            return acc + node.val == sum;
        }
        if (node.left != null && solve(node.left, acc + node.val, sum)) {
            return true;
        }
        if (node.right != null && solve(node.right, acc + node.val, sum)) {
            return true;
        }
        return false;
    }

    public static class TreeNode {
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
