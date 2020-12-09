package algorithm.easy.p122;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[] { 2, 2, 2, 2 }));
    }

    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int answer = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                answer += prices[i] - prices[i - 1];
            }
        }
        return answer;
    }
}
