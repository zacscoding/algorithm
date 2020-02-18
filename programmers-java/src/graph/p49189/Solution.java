package graph.p49189;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49189
 */
class Solution {

    public static void main(String[] args) {
        System.out.println(
                new Solution().solution(
                        6,
                        new int[][] {
                                { 3, 6 },
                                { 4, 3 },
                                { 3, 2 },
                                { 1, 3 },
                                { 1, 2 },
                                { 2, 5 },
                                { 5, 2 },
                                }

                )
        );
    }

    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] g = new ArrayList[n];
        boolean[] visited = new boolean[n];
        int[] counts = new int[n];

        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }

        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0] - 1;
            int v2 = edge[i][1] - 1;

            g[v1].add(v2);
            g[v2].add(v1);
        }

        Queue<Integer> queue = new LinkedList<>();
        visited[0] = true;
        counts[0] = 0;
        queue.offer(0);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int i = 0; i < g[v].size(); i++) {
                int v2 = g[v].get(i);
                if (!visited[v2]) {
                    visited[v2] = true;
                    counts[v2] = counts[v] + 1;
                    queue.offer(v2);
                }
            }
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 1; i < counts.length; i++) {
            final int minCount = counts[i];
            Integer count = map.computeIfAbsent(minCount, k -> Integer.valueOf(0));
            map.put(minCount, count + 1);
        }

        return map.lastEntry().getValue();
    }
}