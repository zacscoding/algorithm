package chap08.dp.p2579;

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
public class Try1 {

    static int[] a = new int[300];
    // dp[i][j] j개 연속 + i 번째 올라갔을 때 최대 점수
    static int[][] dp = new int[300][3];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int n = Reader.nextInt();
        for (int i = 0; i < n; i++) {
            a[i] = Reader.nextInt();
        }

        if (n == 1) {
            System.out.println(a[0]);
        } else if (n == 2) {
            System.out.println(a[0] + a[1]);
        } else {
            dp[1][1] = a[1];

            dp[2][0] = a[1];
            dp[2][1] = a[1] + a[2];

            for (int i = 3; i < n; i++) {
                // dp[i][0] = dp[i - 1][1] + dp[i - 2][1];
                dp[i][0] = dp[i - 1][1];
                dp[i][1] = Math.max(dp[i-2][0] + a[i-1], dp[i-2][1]) + a[i];
            }
            System.out.println(dp[n - 1][1] + a[0]);
        }
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