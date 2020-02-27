package dp.p43105;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */
class Solution {
    public static void main(String[] args) {
        // [[7], [3, 8], [8, 1, 0], [2, 7, 4, 4], [4, 5, 2, 6, 5]]
        System.out.println(new Solution().solution(
                new int[][] {
                        { 7 }
                        , { 3, 8 }
                        , { 8, 1, 0 }
                        , { 2, 7, 4, 4 }
                        , { 4, 5, 2, 6, 5 }
                }
        ));
    }

    static int[][] dp;

    public int solution(int[][] triangle) {
        dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];
        int answer = triangle[0][0];

        int len = triangle.length - 1;

        for (int i = 0; i < triangle[len].length; i++) {
            answer = Math.max(answer, get(triangle, len, i));
        }

        return answer;
    }

    int get(int[][] a, int y, int x) {
        if (y < 0 || x < 0 || x >= dp[y].length) {
            return -1;
        }

        if (dp[y][x] != 0) {
            return dp[y][x];
        }

        return dp[y][x] = Math.max(get(a, y - 1, x - 1), get(a, y - 1, x)) + a[y][x];
    }
}