package algorithm.easy.p455;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/assign-cookies/
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(
                new Solution().findContentChildren(
                        new int[] { 1, 3 },
                        new int[] { 2, 1 }
                )
        );
    }

    public int findContentChildren(int[] g, int[] s) {
        // i : child index, j : cookie index
        int i = 0, j = 0;

        Arrays.sort(g);
        Arrays.sort(s);

        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }
}
