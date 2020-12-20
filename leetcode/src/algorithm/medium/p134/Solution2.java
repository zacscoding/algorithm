package algorithm.medium.p134;

import java.util.*;

/**
 * https://leetcode.com/problems/gas-station/
 */
public class Solution2 {
    public static void main(String[] args) {
        System.out.println(
                new Solution2().canCompleteCircuit(
                        new int[] { 1, 2, 3, 4, 5 },
                        new int[] { 3, 4, 5, 1, 2 }
                )
        );
    }

    public int canCompleteCircuit(int[] gas, int[] cost) {
        List<Integer> possible = new ArrayList<>(gas.length);
        for (int i = 0; i < gas.length; i++) {
            if (gas[i] >= cost[i]) {
                possible.add(i);
            }
        }
        Collections.sort(possible, Comparator.comparingInt(i -> cost[i]));
        for (Integer start : possible) {
            if (possible(gas, cost, start)) {
                return start;
            }
        }
        return -1;
    }

    public boolean possible(int[] gas, int[] cost, int start) {
        int idx = start;
        int remain = gas[start];

        for (int i = 0; i < gas.length; i++) {
            int nextCost = cost[idx];
            if (remain < nextCost) {
                return false;
            }
            idx += 1;
            idx %= gas.length;
            remain += (-nextCost + gas[idx]);
        }
        return true;
    }
}
