package algorithm.easy.p35;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().searchInsert(new int[] { 1, 3, 5, 6 }, 7));
    }

    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (nums[mid] < target) {
                low = mid + 1;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return low;
    }
}
