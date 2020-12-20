package algorithm.medium.p39;

import java.util.*;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/combination-sum/
 */
public class Solution {
    public static void main(String[] args) {
        List<List<Integer>> answer = new Solution().combinationSum(new int[] { 2, 3, 6, 7 }, 7);
        for (List<Integer> a : answer) {
            System.out.println(a.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answers = new ArrayList<>();
        solve(answers, new LinkedList<>(), candidates, 0, target);
        return answers;
    }

    public void solve(List<List<Integer>> answers, List<Integer> answer, int[] candidates, int startIdx, int target) {
        if (target == 0) {
            answers.add(new ArrayList<>(answer));
            return;
        }

        for (int i = startIdx; i < candidates.length; i++) {
            int candidate = candidates[i];
            if (candidate <= target) {
                answer.add(candidate);
                solve(answers, answer, candidates, i, target - candidate);
                answer.remove(answer.size() - 1);
            } else {
                return;
            }
        }
    }
}
