package chap08.dp.p1912;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/1912
 *
 * @author zacconding
 * @Date 2018-11-15
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int[] arr = new int[100001];
    static int[] dp = new int[100001];

    public static void main(String[] args) throws Exception {
        int n = Reader.nextInt();

        for (int i = 1; i <= n; i++) {
            arr[i] = Reader.nextInt();
            dp[i] = dp[i - 1] + arr[i];
        }

        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j++) {
                int p = dp[j] - dp[i - 1];
                max = Math.max(max, p);
            }
        }

        System.out.println(max);
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
