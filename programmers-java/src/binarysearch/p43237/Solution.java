package binarysearch.p43237;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43237
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(
                        new int[] { 120, 110, 140, 150 }, 485
                )
        );
    }

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        long sum = 0;

        for (int i = 0; i < budgets.length; i++) {
            sum += budgets[i];
        }

        if (sum <= M) {
            return budgets[budgets.length - 1];
        }

        int answer = 0;
        int l = 0;
        int h = budgets[budgets.length - 1];
        int prevMid = 0;

        while (true) {
            int mid = (l + h) / 2;

            if (mid == prevMid) {
                answer = mid;
                break;
            }

            sum = 0;

            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] > mid) {
                    sum += mid;
                } else {
                    sum += budgets[i];
                }
            }

            if (sum > M) {
                h = mid;
            } else {
                l = mid;
            }

            prevMid = mid;
        }

        return answer;
    }
}
