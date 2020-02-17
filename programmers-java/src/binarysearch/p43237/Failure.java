package binarysearch.p43237;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43237
 */
public class Failure {

    public static void main(String[] args) {
        System.out.println(
                new Failure().solution(new int[] { 120, 110, 140, 150 }, 485)
        );
    }

    public int solution(int[] budgets, int M) {
        Arrays.sort(budgets);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int len = budgets.length;
        long[] psum = new long[len];
        psum[0] = budgets[0];
        map.put(budgets[0], 0);

        for (int i = 1; i < len; i++) {
            psum[i] = psum[i - 1] + budgets[i];
            map.put(budgets[i], i);
        }

        if (psum[len - 1] <= M) {
            return budgets[len - 1];
        }

        int answer;
        int l = 0;
        int h = budgets[budgets.length - 1];
        int prevMid = 0;

        while (true) {
            int mid = (l + h) / 2;

            if (mid == prevMid) {
                answer = mid;
                break;
            }

            int idx = 0;
            Entry<Integer, Integer> entry = map.floorEntry(mid);
            if (entry != null) {
                idx = entry.getValue();
            }

            long sum = idx == 0 ? mid * len :
                       psum[idx] + (len - idx - 1) * mid;

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
