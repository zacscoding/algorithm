package algorithm.easy.p136;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Solution {
    public int singleNumber(int[] nums) {
        return solveByXOR(nums);
    }

    // Runtime: 10 ms, faster than 19.05% of Java online submissions for Single Number.
    // Memory Usage: 39.9 MB, less than 23.86% of Java online submissions for Single Number.
    public int solveByMap(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer val = map.get(num);
            if (val == null) {
                val = 0;
            }
            val++;
            map.put(num, val);
        }

        for (Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        throw new RuntimeException("unreachable code");
    }

    // Runtime: 1 ms, faster than 88.71% of Java online submissions for Single Number.
    // Memory Usage: 39 MB, less than 79.99% of Java online submissions for Single Number.
    public int solveByXOR(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
