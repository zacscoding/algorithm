package algorithm.easy.p202;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/happy-number/
 */
public class Solution {
    static int[] squared = new int[10];

    static {
        for (int i = 0; i < 10; i++) {
            squared[i] = i * i;
        }
    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int current = n;
        while (true) {
            if (current == 1) {
                return true;
            }
            String nVal = String.valueOf(current);
            int sum = 0;
            for (int i = 0; i < nVal.length(); i++) {
                int v = nVal.charAt(i) - '0';
                sum += squared[v];
            }
            if (sum == 1) {
                return true;
            }
            if (!set.add(sum)) {
                return false;
            }
            current = sum;
        }
    }

    public boolean solve(Set<Integer> set, int n) {
        if (n == 1) {
            return true;
        }

        String nVal = String.valueOf(n);
        int sum = 0;
        for (int i = 0; i < nVal.length(); i++) {
            int v = nVal.charAt(i) - '0';
            sum += squared[v];
        }
        if (sum == 1) {
            return true;
        }
        if (!set.add(sum)) {
            return false;
        }
        return solve(set, sum);
    }
}
