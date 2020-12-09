package algorithm.easy.p53;

/**
 * https://leetcode.com/problems/maximum-subarray/
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(new Solution2().maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        return max(dp, nums, nums.length - 1);
    }

    public int max(int[] dp, int[] nums, int idx) {
        if (dp[idx] != Integer.MIN_VALUE) {
            return dp[idx];
        }
        int max = max(dp, nums, idx - 1);
        int sum = 0;
        for (int i = idx; i >= 0; i--) {
            sum += nums[i];
            if (max < sum) {
                max = sum;
            }
        }
        return dp[idx] = max;
    }
}
