package algorithm.medium.p46;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/permutations/
 */
public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> answer = new Solution().permute(new int[] { 1, 2, 3 });
        for (List<Integer> a : answer) {
            System.out.println(a.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> elts = new ArrayList<>(nums.length);
        for (int num : nums) {
            elts.add(num);
        }
        dfs(answer, elts, new LinkedList<>());
        return answer;
    }

    public void dfs(List<List<Integer>> answers, List<Integer> elts, Deque<Integer> prevElts) {
        if (elts.size() == 0) {
            answers.add(new ArrayList<>(prevElts));
            return;
        }
        for (Integer e : elts) {
            List<Integer> nextElts = new ArrayList<>(elts);
            nextElts.remove(e);

            prevElts.addLast(e);
            dfs(answers, nextElts, prevElts);
            prevElts.pollLast();
        }
    }
}
