package chap08.dp.p1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zacconding
 * @Date 2018-11-19
 * @GitHub : https://github.com/zacscoding
 */
public class Main2 {

    static int[] a = new int[100000];
    // i번째 수로 끝나는 가장 큰 연속합
    static int[] dp;

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        int n = Reader.nextInt();
        dp = new int[n];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = Reader.nextInt();
            if (i == 0) {
                dp[i] = a[i];
            } else {
                dp[i] = dp[i - 1] > 0 ? (dp[i - 1] + a[i]) : a[i];
            }

            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
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
