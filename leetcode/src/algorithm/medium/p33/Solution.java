package algorithm.medium.p33;

import algorithm.util.Printer;

/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0);
    }

    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        // find pivot
        while (low < high) {
            int mid = (low + high) >> 1;
            Printer.out("# Find pivot. Check Mid:%d", mid);
            if (nums[mid] > nums[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        int pivot = low;

        low = 0;
        high = nums.length - 1;

        while (low <= high) {
            int mid = (low + high) >> 1;
            int midPivot = (mid + pivot) % nums.length;
            Printer.out("# Find target. low:%d, high:%d, mid:%d, mid pivot:%d, nums[midPivot]: %d",
                        low, high, mid, midPivot, nums[midPivot]);
            if (nums[midPivot] < target) {
                low = mid + 1;
            } else if (nums[midPivot] > target) {
                high = mid - 1;
            } else {
                return midPivot;
            }
        }
        return -1;
    }
}
