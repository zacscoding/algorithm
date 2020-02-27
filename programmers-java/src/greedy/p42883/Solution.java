package greedy.p42883;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 * TODO : re
 */
public class Solution {

    public String solution(String number, int k) {
        if (number.length() == k) {
            return "";
        }

        if (k == 0) {
            return number;
        }

        if (k == 1) {
            return number.substring(1);
        }

        int maxIdx = -1;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < k; i++) {
            int t = number.charAt(i) - '0';
            if (t > max) {
                maxIdx = i;
                max = t;
            }
        }

        String prefix = "" + number.charAt(maxIdx);
        return prefix + solution(number.substring(maxIdx + 1), k - maxIdx);
    }
}
