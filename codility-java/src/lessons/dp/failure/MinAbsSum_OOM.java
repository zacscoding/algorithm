package lessons.dp.failure;

public class MinAbsSum_OOM {
    public static void main(String[] args) {
        System.out.println(
                new MinAbsSum_OOM().solution(
                        // new int[] { 1, 5, -2, 5, 2, 3 }
                        new int[] { 1, 5, 5, 2, 2, 3 }
                )
        );
    }

    public int solution(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        if (A.length == 1) {
            return Math.abs(A[0]);
        }

        int[][] dp = new int[A.length][];
        dp[0] = new int[] { Math.abs(A[0]) };

        int answer = dp[0][0];
        int len = 1;

        for (int i = 1; i < A.length; i++) {
            // initialize answer
            answer = Integer.MAX_VALUE;
            len *= 2;
            dp[i] = new int[len];
            for (int j = 0; j < dp[i - 1].length; j++) {
                int a1 = Math.abs(dp[i - 1][j] + A[i]);
                int a2 = Math.abs(dp[i - 1][j] - A[i]);
                answer = Math.min(Math.min(a1, a2), answer);
                dp[i][2 * j] = a1;
                dp[i][2 * j + 1] = a2;
            }
        }

        return answer;
    }
}
