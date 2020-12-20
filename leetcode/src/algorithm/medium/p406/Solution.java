package algorithm.medium.p406;

import java.util.*;

import algorithm.util.Printer;

/**
 * https://leetcode.com/problems/queue-reconstruction-by-height/
 */
public class Solution {
    public static void main(String[] args) {
        int[][] answer = new Solution().reconstructQueue(new int[][] {
                { 7, 0 },
                { 4, 4 },
                { 7, 1 },
                { 5, 0 },
                { 6, 1 },
                { 5, 2 },
                });
        for (int i = 0; i < answer.length; i++) {
            Printer.out("[%d, %d]", answer[i][0], answer[i][1]);
        }
    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> {
            int dh = a[0] - b[0];
            if (dh != 0) {
                return -dh;
            }
            return a[1] - b[1];
        });

        List<int[]> list = new ArrayList<>(people.length);
        for (int i = 0; i < people.length; i++) {
            list.add(people[i][1], people[i]);
        }
        return list.toArray(new int[people.length][2]);
    }
}
