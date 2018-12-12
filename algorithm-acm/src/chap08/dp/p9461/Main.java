package chap08.dp.p9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2225
 *
 * @author zacconding
 * @Date 2018-12-12
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int mod = 1000000000;
    static int N;
    static int K;
    static int[][] dp = new int[201][201];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        N = Reader.nextInt();
        K = Reader.nextInt();

        dp[0][0] = 1;

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j <= N; j++) {
                for (int l = 0; l <= j; l++) {
                    dp[j][i] += dp[j - l][i - 1];
                    dp[j][i] %= mod;
                }
            }
        }

        System.out.println(dp[N][K]);
    }

    static class Reader {

        static BufferedReader reader;
        static StringTokenizer tokenizer;

        static {
            Reader.init(System.in);
        }

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
