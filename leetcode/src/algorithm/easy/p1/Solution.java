package algorithm.easy.p1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(
                Arrays.toString(new Solution().twoSum_twoPoint(new int[] { 3, 2, 4 }, 6))
        );
    }

    // brute force
    public int[] twoSum_bruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        throw new RuntimeException("unreachable code");
    }

    // map
    public int[] twoSum_map(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null && idx != i) {
                return new int[] { i, idx };
            }
        }
        throw new RuntimeException("unreachable code");
    }

    public int[] twoSum_map2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            Integer idx = map.get(target - nums[i]);
            if (idx != null) {
                return new int[] { i, idx };
            }
            map.put(nums[i], i);
        }
        throw new RuntimeException("unreachable code");
    }

    // two point with pair
    public int[] twoSum_twoPoint(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(i, nums[i]);
        }
        Arrays.sort(pairs, Comparator.comparingInt(p -> p.value));
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = pairs[left].value + pairs[right].value;
            if (sum == target) {
                return new int[] { pairs[left].idx, pairs[right].idx };
            } else if (sum < target) {
                left += 1;
            } else {
                right -= 1;
            }
        }
        throw new RuntimeException("unreachable code");
    }

    public static class Pair {
        int idx;
        int value;

        public Pair(int l, int r) {
            this.idx = l;
            this.value = r;
        }
    }
}
