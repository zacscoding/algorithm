package algorithm.medium.p93;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/restore-ip-addresses/
 */
public class Solution {

    public static void main(String[] args) {
        List<String> answers = new Solution().restoreIpAddresses("172162541");
        System.out.println(answers.stream().collect(Collectors.joining("\n")));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> answers = new ArrayList<>();
        solve(answers, new StringBuilder(0), s, 4);
        return answers;
    }

    public static void solve(List<String> answers, StringBuilder currentAnswer, String remain, int count) {
        if (count == 0) {
            if (remain.length() == 0) {
                answers.add(currentAnswer.toString());
            }
            return;
        }
        if (remain.length() == 0) {
            return;
        }
        if (count != 4) {
            currentAnswer.append('.');
        }

        // 1) x.
        StringBuilder currentAnswer1 = new StringBuilder(currentAnswer)
                .append(remain.charAt(0));
        solve(answers, currentAnswer1, remain.substring(1), count - 1);

        // 2) xy.
        if (remain.length() < 2 || remain.charAt(0) == '0') {
            return;
        }
        StringBuilder currentAnswer2 = new StringBuilder(currentAnswer)
                .append(remain.charAt(0))
                .append(remain.charAt(1));
        solve(answers, currentAnswer2, remain.substring(2), count - 1);

        // 3) xyz.
        if (remain.length() < 3) {
            return;
        }
        int digit = Integer.parseInt(new StringBuilder(3)
                                             .append(remain.charAt(0))
                                             .append(remain.charAt(1))
                                             .append(remain.charAt(2))
                                             .toString());
        if (digit > 255) {
            return;
        }
        StringBuilder currentAnswer3 = new StringBuilder(currentAnswer)
                .append(remain.charAt(0))
                .append(remain.charAt(1))
                .append(remain.charAt(2));
        solve(answers, currentAnswer3, remain.substring(3), count - 1);
    }
}


