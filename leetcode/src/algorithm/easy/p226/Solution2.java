package algorithm.easy.p226;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class Solution2 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(3);
        TreeNode node7 = new TreeNode(7);
        node7.left = new TreeNode(6);
        node7.right = new TreeNode(9);
        root.left = node2;
        root.right = node7;
        traverse(root);
    }

    public static void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        traverse(node.left);
        System.out.print(node.val + " ");
        traverse(node.right);
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        invert(root, root.left, root, root.right);
        return root;
    }

    public void insertOutside(TreeNode leftP, TreeNode left, TreeNode rightP, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        swapChild(left, right);
        leftP.left = right;
        rightP.right = left;
        TreeNode temp = left;
        left = right;
        right = temp;

    }

    public void invert(TreeNode leftParent, TreeNode left, TreeNode rightParent, TreeNode right) {
        if (left == null && right == null) {
            return;
        }
        swapChild(left, right);
    }

    public void swapChild(TreeNode left, TreeNode right) {
        TreeNode temp = left.left;
        left.left = right.left;
        right.left = temp;

        temp = left.right;
        left.right = right.right;
        right.right = temp;
    }
}