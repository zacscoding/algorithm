package graph.p43162;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */
class Solution {

    public int solution(int n, int[][] computers) {
        int answer = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                answer++;
                dfs(computers, visited, i);
            }
        }

        return answer;
    }

    void dfs(int[][] computers, boolean[] visited, int visit) {
        visited[visit] = true;

        for (int i = 0; i < computers[visit].length; i++) {
            if (visit != i && computers[visit][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }

    }
}
