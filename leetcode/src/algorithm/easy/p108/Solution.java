package algorithm.easy.p108;

/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 */
public class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {
        return solution1(nums);
    }

    public TreeNode solution1(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int mid = nums.length >> 1;
        TreeNode root = new TreeNode(nums[mid]);

        // left
        if (mid != 0) {
            int[] leftNums = new int[mid];
            System.arraycopy(nums, 0, leftNums, 0, mid);
            root.left = solution1(leftNums);
        }

        // right
        if (mid != nums.length - 1) {
            int[] rightNums = new int[nums.length - mid - 1];
            System.arraycopy(nums, mid + 1, rightNums, 0, nums.length - mid - 1);
            root.right = solution1(rightNums);
        }

        return root;
    }

    public TreeNode solution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int mid = nums.length >> 1;
        TreeNode root = new TreeNode(nums[mid]);
        appendTreeNode(nums, root, 0, mid - 1, true);
        appendTreeNode(nums, root, mid + 1, nums.length - 1, false);
        return root;
    }

    public void appendTreeNode(int[] nums, TreeNode parent, int left, int right, boolean appendLeft) {
        if (left > right) {
            return;
        }

        int mid = (left + right + 1) >> 1;
        TreeNode node = new TreeNode(nums[mid]);
        if (appendLeft) {
            parent.left = node;
        } else {
            parent.right = node;
        }
        appendTreeNode(nums, node, left, mid - 1, true);
        appendTreeNode(nums, node, mid + 1, right, false);
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
