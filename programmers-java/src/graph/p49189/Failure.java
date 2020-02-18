package graph.p49189;

import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

/**
 */
public class Failure {

    public static void main(String[] args) {
        System.out.println(
                new Failure().solution(
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
        int[][] g = new int[n][n];
        boolean[] visited = new boolean[n];
        int[] counts = new int[n];

        for (int i = 0; i < edge.length; i++) {
            int v1 = edge[i][0] - 1;
            int v2 = edge[i][1] - 1;

            g[v1][v2] = g[v2][v1] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        visit(queue, visited, counts, 0, 0);

        while (!queue.isEmpty()) {
            int v = queue.poll();

            for (int i = 0; i < g[v].length; i++) {
                if (g[v][i] == 1 && !visited[i]) {
                    visit(queue, visited, counts, i, counts[v] + 1);
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

    void visit(Queue<Integer> queue, boolean[] visited, int[] counts, int v, int count) {
        visited[v] = true;
        counts[v] = count;
        queue.add(v);
    }
}