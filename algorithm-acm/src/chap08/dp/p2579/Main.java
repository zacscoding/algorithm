package chap08.dp.p2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2579
 *
 * @author zacconding
 * @Date 2018-11-21
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int[] a = new int[301];
    static int[][] dp = new int[301][2];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();

        a[1] = Reader.nextInt();
        dp[1][0] = a[1];

        for (int i = 2; i <= n; i++) {
            a[i] = Reader.nextInt();
            dp[i][0] = Math.max(dp[i - 2][0], dp[i - 2][1]) + a[i];
            dp[i][1] = dp[i - 1][0] + a[i];
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));
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