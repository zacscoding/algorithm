package chap08.dp.p1699;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1699
 *
 * @author zacconding
 * @Date 2018-11-21
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int[] dp = new int[100001];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        dp[1] = 1;
        dp[2] = 2;
        int n = Reader.nextInt();
        System.out.println(solve(n));
    }

    public static int solve(int n) {
        if (dp[n] != 0) {
            return dp[n];
        }

        int start = (int) Math.sqrt(n);
        int min = n;
        for (int i = start; i > 0; i--) {
            int remain = n - (i * i);
            min = Math.min(min, solve(remain) + 1);
        }

        return dp[n] = min;
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