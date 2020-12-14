package algorithm.medium.p33;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(
                new Solution2().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0)
        );
        System.out.println(
                new Solution2().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 3)
        );
        System.out.println(
                new Solution2().search(new int[] { 1 }, 0)
        );
    }

    public int search(int[] nums, int target) {
        int pivot = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                pivot = i;
                break;
            }
        }

        int low, high;
        if (target >= nums[0] && target <= nums[pivot]) {
            low = 0;
            high = pivot;
        } else {
            low = pivot + 1;
            high = nums.length - 1;
        }

        while (low <= high) {
            int mid = (low + high) >> 1;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
