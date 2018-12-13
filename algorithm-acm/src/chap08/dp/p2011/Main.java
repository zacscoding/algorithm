package chap08.dp.p2011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zacconding
 * @Date 2018-12-13
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    static int mod = 1000000;
    static char[] input;
    static int[] dp = new int[5001];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        input = (" " + Reader.next().trim()).toCharArray();
        dp[0] = 1;

        for (int i = 1; i < input.length; i++) {
            if ('1' <= input[i] && input[i] <= '9') {
                dp[i] = (dp[i] + dp[i - 1]) % mod;
            }

            if (i == 1 || input[i - 1] == '0') {
                continue;
            }

            int x = (input[i - 1] - '0') * 10 + (input[i] - '0');
            if (x >= 10 && x <= 26) {
                dp[i] = (dp[i] + dp[i - 2]) % mod;
            }
        }

        System.out.println(dp[input.length - 1]);
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
