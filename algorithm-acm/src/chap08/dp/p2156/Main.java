package chap08.dp.p2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2156
 *
 * @author zaccoding
 * github : https://github.com/zacscoding
 */
public class Main {
    // dp[i][j]
    // 1) [i][0] : i번째까지 0번 연속 최대 == a[i] X
    // 1) [i][1] : i번쨰까지 1번 연속 최대 == a[i] O &% a[i-1] X
    // 1) [i][2] : i번째까지 2번 연속 최대 == a[i] O && a[i-1] O
    static int[][] dp = new int[10001][3];
    static int[] a = new int[10001];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        int n = Reader.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = Reader.nextInt();
        }

        if (n <= 2) {
            System.out.println(n == 1 ? a[1] : a[1] + a[2]);
            return;
        }

        dp[1][1] = a[1];
        dp[1][2] = a[1];
        for (int i = 2; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
            dp[i][1] = dp[i - 1][0] + a[i];
            dp[i][2] = dp[i - 1][1] + a[i];
        }

        System.out.println(Math.max(dp[n][0], Math.max(dp[n][1], dp[n][2])));

        Reader.close();
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

        public static void close() {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
    }
}
