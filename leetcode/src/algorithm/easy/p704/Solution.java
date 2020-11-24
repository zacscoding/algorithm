package algorithm.easy.p704;

/**
 * https://leetcode.com/problems/binary-search/
 */
public class Solution {

    public static void main(String[] args) {
        int target = 0;
        // int[] nums = new int[] { -1, 0, 3, 5, 9, 12 };
        int[] nums = new int[] { 0, 5 };

        System.out.println(
                new Solution().search(nums, target)
        );
    }

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + high >> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
