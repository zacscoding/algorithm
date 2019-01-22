package chap08.dp.p1509;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1509
 */
public class Main {

    static boolean[][] c;
    static int[] dp;

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        String input = Reader.nextLine();
        int n = input.length();
        input = " " + input;
        c = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            c[i][i] = true;
        }

        for (int i = 1; i <= n - 1; i++) {
            if (input.charAt(i) == input.charAt(i + 1)) {
                c[i][i + 1] = true;
            }
        }

        for (int k = 2; k < n; k++) {
            for (int i = 1; i <= n - k; i++) {
                int j = i + k;
                c[i][j] = (input.charAt(i) == input.charAt(j) && c[i + 1][j - 1]);
            }
        }

        dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = -1;
            for (int j = 1; j <= i; j++) {
                if (c[j][i]) {
                    if (dp[i] == -1 || dp[i] > dp[j - 1] + 1) {
                        dp[i] = dp[j - 1] + 1;
                    }
                }
            }
        }

        System.out.println(dp[n]);
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
