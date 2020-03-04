package chap08.dp.p1932;

import java.io.*;
import java.util.*;
import java.util.zip.CheckedOutputStream;

/**
 * https://github.com/zacscoding
 *
 * https://www.acmicpc.net/problem/1932
 */
public class Main {

    static int[][] a;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        int n = Reader.nextInt();

        a = new int[n][];
        dp = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = new int[i + 1];
            dp[i] = new int[i + 1];

            for (int j = 0; j <= i; j++) {
                a[i][j] = Reader.nextInt();
            }
        }

        dp[0][0] = a[0][0];

        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, solve(n - 1, i));
        }
        System.out.println(max);
    }

    static int solve(int i, int j) {
        if (i < 0 || i >= a.length || j < 0 || j >= a[i].length) {
            return 0;
        }

        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        return dp[i][j] = Math.max(solve(i - 1, j - 1), solve(i - 1, j))
                          + a[i][j];
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
