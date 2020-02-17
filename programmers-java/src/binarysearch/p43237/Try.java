package binarysearch.p43237;

import java.util.Arrays;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43237
 */
class Try {

    public static void main(String[] args) {
        Try solution = new Try();
        int[] budgets = new int[] { 100, 120, 110, 140, 150 };
        int M = 585;
        int sol1 = solution.solution(budgets, M);
        int sol2 = solution.solution2(budgets, M);
        if (sol1 != sol2) {
            System.out.println("Find diff. sol1 : " + sol1 + ", sol2 : " + sol2);
        }
//        System.out.println(
//                new Solution().solution2(
//                        new int[] { 120, 110, 140, 150 }, 490
//                )
//        );
    }

    public int solution(int[] budgets, int M) {
        int len = budgets.length;
        int[] psum = new int[len];
        psum[0] = budgets[0];

        for (int i = 1; i < len; i++) {
            psum[i] = budgets[i] + psum[i - 1];
        }

        if (psum[len - 1] <= M) {
            return budgets[len - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            int sum = psum[i] + (len - i - 1) * budgets[i];

            if (sum <= M) {
                return (M - psum[i]) / (len - i - 1);
            }
        }

        return M / len;
    }

    public int solution2(int[] budgets, int M) {
        int[] copy = new int[budgets.length];
        System.arraycopy(budgets, 0, copy, 0, budgets.length);
        Arrays.sort(copy);

        int answer = copy[copy.length - 1];

        while (true) {
            int sum = 0;

            for (int i = 0; i < budgets.length; i++) {
                if (budgets[i] > answer) {
                    sum += answer;
                } else {
                    sum += budgets[i];
                }
            }

            if (sum <= M) {
                return answer;
            }

            answer--;
        }
    }
}