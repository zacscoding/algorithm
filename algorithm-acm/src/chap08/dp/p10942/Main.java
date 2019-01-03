package chap08.dp.p10942;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zacconding
 * @Date 2019-01-03
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int N, M;
    static int[] a = new int[2001];
    static boolean[][] dp = new boolean[2001][2001];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        N = Reader.nextInt();

        for (int i = 1; i <= N; i++) {
            a[i] = Reader.nextInt();
            // length 1
            dp[i][i] = true;
        }

        // length 2
        for (int i = 1; i < N; i++) {
            if (a[i] == a[i + 1]) {
                dp[i][i + 1] = true;
            }
        }

        // length 3 ~
        for (int k = 2; k < N; k++) {
            for (int i = 1; i <= N - k; i++) {
                // length k
                int j = i + k;
                if (a[i] == a[j] && dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                }
            }
        }

        M = Reader.nextInt();

        StringBuilder sb = new StringBuilder(M * 2);
        for (int i = 0; i < M; i++) {
            int s = Reader.nextInt();
            int e = Reader.nextInt();
            if (dp[s][e]) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            sb.append("\n");
        }
        
        System.out.println(sb);
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
