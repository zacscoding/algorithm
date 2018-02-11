package chap08.dp.p11722;

import java.io.*;
import java.util.*;

/**
 * @author zacconding
 * @Date 2018-02-11
 * @GitHub : https://github.com/zacscoding
 */
public class Try1 {

    public static int n;
    public static int[] dp = new int[1001];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        n = Reader.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            a[i] = Reader.nextInt();
        }

        dp[1] = 1;
        int answer = dp[1];
        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= n; j++) {
                if (a[i] < a[j] && (dp[i] < dp[j] + 1)) {
                    dp[i] = dp[j] + 1;
                }
            }

            answer = Math.max(answer, dp[i]);
        }
        System.out.println(answer);
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
