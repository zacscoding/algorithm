package chap08.dp.p2193;

import java.io.*;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/2193
 *
 * @author zacconding
 * @Date 2018-01-27
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    // dp[i][j] : 길이가 i이고 j로 끝나는 이친수 수
    public static long[][] dp = new long[91][2];

    public static void main(String[] args) throws Exception {
        Reader.init(System.in);
        int N = Reader.nextInt();
        dp[1][1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0];
        }
        long answer = dp[N][0] + dp[N][1];
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
    }
}
