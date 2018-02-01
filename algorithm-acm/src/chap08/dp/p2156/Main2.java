package chap08.dp.p2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zaccoding
 * github : https://github.com/zacscoding
 */
public class Main2 {
    // a1...ai 까지 마실 떄 최대 양
    static int[] dp = new int[10001];
    static int[] a = new int[10001];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);

        int n = Main.Reader.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = Main.Reader.nextInt();
        }
        dp[1] = a[1];
        dp[2] = a[2] + a[1];
        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max( (dp[i - 2] + a[i]) , (dp[i - 3] + a[i - 1] + a[i]) ));
        }

        System.out.println(dp[n]);
        Main.Reader.close();
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
