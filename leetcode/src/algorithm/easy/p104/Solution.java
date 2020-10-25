package algorithm.easy.p104;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class Solution {

    public int maxDepth(TreeNode root) {
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
