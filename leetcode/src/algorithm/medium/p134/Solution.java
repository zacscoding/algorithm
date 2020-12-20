package algorithm.medium.p134;

/**
 * https://leetcode.com/problems/gas-station/submissions/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().canCompleteCircuit(
                        new int[] { 2, 3, 4 },
                        new int[] { 3, 4, 3 }
                )
        );
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0, costSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }
        if (gasSum < costSum) {
            return -1;
        }

        int start = 0, fuel = 0;
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] + fuel < cost[i]) {
                start = i + 1;
                fuel = 0;
            } else {
                fuel += gas[i] - cost[i];
            }
        }
        return start;
    }
}
