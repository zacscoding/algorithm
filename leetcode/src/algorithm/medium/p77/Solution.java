package algorithm.medium.p77;

import java.util.*;
import java.util.stream.Collectors;

import algorithm.util.Printer;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> answer = new Solution().combine(5, 3);
        for (List<Integer> a : answer) {
            System.out.println(a.stream().map(i -> String.valueOf(i)).collect(Collectors.joining(",")));
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answers = new ArrayList<>();
        dfs(answers, new LinkedList<>(), n, 1, k);
        return answers;
    }

    public void dfs(List<List<Integer>> answers, Deque<Integer> elts, int n, int start, int remain) {
        if (remain == 0) {
            answers.add(new ArrayList<>(elts));
            return;
        }

        for (int i = start; i <= n; i++) {
            if (n - i + 1 < remain) {
                return;
            }

            elts.addLast(i);
            Printer.out("Visit:%d -> %s", i, elts.stream().map(j -> "" + j).collect(Collectors.joining(",")));
            dfs(answers, elts, n, i + 1, remain - 1);
            int e = elts.pollLast();
            Printer.out("Poll:%d", e);
        }
    }
}
