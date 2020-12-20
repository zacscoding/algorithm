package algorithm.medium.p207;

import java.util.*;

public class Solution_timeout {
    public static void main(String[] args) {
        System.out.println(
                new Solution_timeout().canFinish(
                        2,
                        new int[][] {
                                { 1, 0 },
                                { 0, 1 }
                        }
                )
        );
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
        }
        // make graph
        int[][] adj = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[0]][prerequisite[1]] = 1;
        }
        List<Integer> remain = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            remain.add(i);
        }
        return dfs(adj, remain);
    }

    public boolean dfs(int[][] adj, List<Integer> remain) {
        if (remain.isEmpty()) {
            return true;
        }
        for (int i = 0; i < remain.size(); i++) {
            int r = remain.get(i);
            // check can visit or not
            boolean require = false;
            for (int j = 0; j < adj.length; j++) {
                if (adj[j][r] == 1) {
                    require = true;
                    break;
                }
            }
            if (require) {
                continue;
            }
            // remove edges
            List<Integer> rollback = new ArrayList<>();
            for (int j = 0; j < adj.length; j++) {
                if (adj[r][j] == 1) {
                    rollback.add(j);
                    adj[r][j] = 0;
                }
            }
            remain.remove(i);
            if (dfs(adj, remain)) {
                return true;
            }
            // rollback
            remain.add(i, r);
            for (Integer j : rollback) {
                adj[r][j] = 1;
            }
        }
        return false;
    }
}
