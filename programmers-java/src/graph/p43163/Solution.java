package graph.p43163;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */
class Solution {

    public int solution(String begin, String target, String[] words) {
        Map<String, Integer> indexMap = new HashMap<>();
        int idx = 0;
        indexMap.put(begin, idx++);
        for (int i = 0; i < words.length; i++) {
            if (indexMap.containsKey(words[i])) {
                continue;
            }

            indexMap.put(words[i], idx++);
        }

        if (!indexMap.containsKey(target)) {
            return 0;
        }

        int[][] g = new int[indexMap.size()][indexMap.size()];
        List<String> keys = new ArrayList<>(indexMap.keySet());

        for (int i = 0; i < keys.size() - 1; i++) {
            String w1 = keys.get(i);

            for (int j = i + 1; j < keys.size(); j++) {
                String w2 = keys.get(j);
                if (isConvertible(w1, w2)) {
                    int v1 = indexMap.get(w1);
                    int v2 = indexMap.get(w2);
                    g[v1][v2] = g[v2][v1] = 1;
                }
            }
        }

        int n = indexMap.size();
        boolean[] visited = new boolean[n];
        int[] len = new int[n];
        int targetIdx = indexMap.get(target);

        Queue<Integer> que = new LinkedList<>();
        que.offer(0);
        visited[0] = true;

        while (!que.isEmpty()) {
            int v = que.poll();

            for (int i = 0; i < n; i++) {
                if (g[v][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    que.offer(i);
                    len[i] = len[v] + 1;
                }
            }
        }

        return len[targetIdx];
    }

    void bfs(Queue<Integer> que, int[][] g, boolean[] visited, int[] len, int v, int curLen) {
        visited[v] = true;
        len[v] = curLen;

    }

    boolean isConvertible(String w1, String w2) {
        int diff = 0;

        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                if (diff != 0) {
                    return false;
                }

                diff++;
            }
        }

        return true;
    }
}
