package chap08.dp.p10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/10942
 */
public class Main2 {

    static int[][] dp = new int[2001][2001];
    static int[] seq = new int[2001];
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        N = Reader.nextInt();

        for (int i = 1; i <= N; i++) {
            seq[i] = Reader.nextInt();
            dp[i][i] = 1;
        }

        M = Reader.nextInt();
        StringBuilder sb = new StringBuilder(M * 2);
        for (int i = 0; i < M; i++) {
            int result = solve(Reader.nextInt(), Reader.nextInt());
            sb.append(result % 2).append("\n");
        }

        System.out.println(sb);
    }

    public static int solve(int a, int b) {
        if (dp[a][b] != 0) {
            return dp[a][b];
        }

        if (a + 1 == b) {
            return dp[a][b] = (seq[a] == seq[b] ? 1 : 2);
        }

        if (seq[a] != seq[b]) {
            return dp[a][b] = 2;
        }

        return dp[a][b] = solve(a + 1, b - 1);
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
