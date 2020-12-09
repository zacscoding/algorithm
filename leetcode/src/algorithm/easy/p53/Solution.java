package algorithm.easy.p53;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public int maxSubArray(int[] nums) {
        int prevSum = nums[0];
        int max = prevSum;
        for (int i = 1; i < nums.length; i++) {
            prevSum = Math.max(prevSum + nums[i], nums[i]);
            if (max < prevSum) {
                max = prevSum;
            }
        }
        return max;
    }
}
