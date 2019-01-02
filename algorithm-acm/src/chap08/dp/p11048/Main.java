package chap08.dp.p11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11048
 */
public class Main {

    static int[][] a = new int[1001][1001];
    static int[][] dp = new int[1001][1001];
    static int N, M;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        N = Reader.nextInt();
        M = Reader.nextInt();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                a[i][j] = Reader.nextInt();
            }
        }

        dp[1][1] = a[1][1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = dp[i][j - 1];
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - 1]);
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                dp[i][j] += a[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        public static void init(InputStream input) {
            reader = new BufferedReader(new InputStreamReader(input));
        }


        public static String nextLine() throws IOException {
            return reader.readLine();
        }

        public static String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        public static int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }
}
