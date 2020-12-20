package algorithm.medium.p78;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/subsets/
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> answer = new Solution().subsets(new int[] { 1, 2, 3 });

        System.out.println(
                answer.stream()
                      .map(a -> a.stream().map(i -> "" + i).collect(Collectors.joining(",")))
                      .collect(Collectors.joining("\n"))
        );
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answers = new ArrayList<>();
        dfs(answers, new ArrayList<>(), 0, nums);
        return answers;
    }

    public void dfs(List<List<Integer>> answers, List<Integer> path, int startIdx, int[] nums) {
        answers.add(new ArrayList<>(path));

        for (int i = startIdx; i < nums.length; i++) {
            path.add(nums[i]);
            dfs(answers, path, i + 1, nums);
            path.remove(path.size() - 1);
        }
    }
}
