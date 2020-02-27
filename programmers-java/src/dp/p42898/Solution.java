package dp.p42898;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */
class Solution {

    static final int modulo = 1000000007;
    static int[] dy = { 0, -1 };
    static int[] dx = { -1, 0 };
    static int[][] dp;

    public int solution(int m, int n, int[][] puddles) {
        if (n == 1 && m == 1) {
            return 0;
        }

        dp = new int[n][m];
        dp[0][0] = 1;

        for (int i = 0; i < puddles.length; i++) {
            dp[puddles[i][1] - 1][puddles[i][0] - 1] = -1;
        }

        return solve(n, m, n - 1, m - 1);
    }

    int solve(int n, int m, int y, int x) {
        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        int count = 0;

        for (int k = 0; k < 2; k++) {
            int y2 = y + dy[k];
            int x2 = x + dx[k];

            if (isRange(n, m, y2, x2)) {
                int t = solve(n, m, y2, x2);
                if (t > 0) {
                    count = (count + t) % modulo;
                }
            }
        }

        return dp[y][x] = count;
    }

    boolean isRange(int n, int m, int y, int x) {
        if (y < 0 || y >= n || x < 0 || x >= m) {
            return false;
        }

        return true;
    }
}