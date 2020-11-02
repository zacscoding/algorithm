package algorithm.medium.p200;

/**
 * https://leetcode.com/problems/number-of-islands/
 */
public class Solution {

    public static void main(String[] args) {
        char[][] grid = new char[][] {
                { '1', '1', '0', '0', '0' },
                { '1', '1', '0', '0', '0' },
                { '0', '0', '1', '0', '0' },
                { '0', '0', '0', '1', '1' }
        };
        System.out.println(
                new Solution().numIslands(grid)
        );
    }

    static int[] dy = { -1, 0, 1, 0 };
    static int[] dx = { 0, 1, 0, -1 };

    public int numIslands(char[][] grid) {
        return solveByDFS(grid);
    }

    public int solveByBFS(char[][] grid) {
        // TODO
        return 0;
    }

    public int solveByDFS(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][];
        for (int i = 0; i < grid.length; i++) {
            visited[i] = new boolean[grid[i].length];
        }

        int answer = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    answer++;
                    dfs(grid, visited, i, j);
                }
            }
        }

        return answer;
    }

    public void dfs(char[][] grid, boolean[][] visited, int y, int x) {
        visited[y][x] = true;
        for (int k = 0; k < 4; k++) {
            int newY = y + dy[k];
            int newX = x + dx[k];
            if (newY >= 0 && newY < grid.length && newX >= 0 && newX < grid[newY].length
                && grid[newY][newX] == '1' && !visited[newY][newX]) {
                dfs(grid, visited, newY, newX);
            }
        }
    }
}
