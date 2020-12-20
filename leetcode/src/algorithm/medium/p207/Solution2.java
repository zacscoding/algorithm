package algorithm.medium.p207;

import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        System.out.println(
                new Solution2().canFinish(
                        2,
                        new int[][] {
                                { 1, 0 },
                                }
                )
        );
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 1) {
            return true;
        }
        // make graph
        ArrayList<Integer>[] adj = (ArrayList<Integer>[]) new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] prerequisite : prerequisites) {
            adj[prerequisite[0]].add(prerequisite[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adj, new HashSet<>(), new HashSet<>(), i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(ArrayList<Integer>[] adj, Set<Integer> traced, Set<Integer> visited, int v) {
        if (traced.contains(v)) {
            return false;
        }
        if (visited.contains(v)) {
            return true;
        }
        traced.add(v);
        for (Integer next : adj[v]) {
            if (!dfs(adj, traced, visited, next)) {
                return false;
            }
        }
        traced.remove(v);
        visited.add(v);
        return true;
    }
}
