package algorithm.hard.p239;

import java.util.*;

public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        // build left and right arrays
        int[] left = new int[n];
        int[] right = new int[n];
        for (int j = 0; j < n; j += k) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < k; i++) {
                if (i + j < n) {
                    max = Math.max(max, nums[j + i]);
                    left[j + i] = max;
                }
            }

            max = Integer.MIN_VALUE;
            for (int i = k - 1; i >= 0; i--) {
                if (i + j < n) {
                    max = Math.max(max, nums[j + i]);
                    right[j + i] = max;
                }
            }
        }
        // build result
        for (int i = 0; i < n - k + 1; i++) {
            result[i] = Math.max(right[i], left[i + k - 1]);
        }

        return result;
    }

    // 	Time Limit Exceeded
    public int[] solveByDeque(int[] nums, int k) {
        ArrayDeque<Integer> deque = new ArrayDeque<>(k + 1);
        int[] answer = new int[nums.length - k + 1];
        int idx = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            deque.add(nums[i]);
            if (i < k - 1) {
                continue;
            }

            if (max == Integer.MIN_VALUE) {
                for (int t : deque) {
                    if (max < t) {
                        max = t;
                    }
                }
            } else if (nums[i] > max) {
                max = nums[i];
            }

            answer[idx++] = max;

            if (max == deque.poll()) {
                max = Integer.MIN_VALUE;
            }
        }
        return answer;
    }

    // 	Time Limit Exceeded
    public int[] solveByBruteForce(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        int idx = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            int max = nums[i];
            for (int j = i + 1; j <= i + k - 1; j++) {
                if (max < nums[j]) {
                    max = nums[j];
                }
            }
            answer[idx++] = max;
        }
        return answer;
    }

    // Runtime: 309 ms, faster than 10.00% of Java online submissions for Sliding Window Maximum.
    // Memory Usage: 56 MB, less than 25.50% of Java online submissions for Sliding Window Maximum.
    public int[] solveBySortedMap(int[] nums, int k) {
        int[] answer = new int[nums.length - k + 1];
        int idx = 0;
        NavigableMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < k; i++) {
            Integer val = map.get(nums[i]);
            if (val == null) {
                val = 0;
            }
            map.put(nums[i], val + 1);
        }
        answer[idx++] = map.lastKey();

        for (int i = 1; i <= nums.length - k; i++) {
            // remove left
            int leftVal = map.get(nums[i - 1]) - 1;
            if (leftVal == 0) {
                map.remove(nums[i - 1]);
            } else {
                map.put(nums[i - 1], leftVal);
            }

            // add right
            Integer rightVal = map.get(nums[i + k - 1]);
            if (rightVal == null) {
                rightVal = 0;
            }
            map.put(nums[i + k - 1], rightVal + 1);
            answer[idx++] = map.lastKey();
        }
        return answer;
    }

}