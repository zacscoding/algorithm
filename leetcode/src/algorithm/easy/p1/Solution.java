package algorithm.easy.p1;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/two-sum/
 *
 * @GitHub : https://github.com/zacscoding
 */
public class Solution {

    public static void main(String[] args) {
        String a = Arrays.toString(new Solution().twoSum(new int[]{2,7,11,15}, 9));
        System.out.println(a);
    }

    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ret[0] = i;
                    ret[1] = j;
                    return ret;
                }
            }
        }

        return ret;
    }
}
