package chap08.dp.p11055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * https://www.acmicpc.net/problem/11055
 *
 * @author zacconding
 * @Date 2018-02-11
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    public static int N;
    public static int[] dp = new int[1001];
    public static int[] A;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        N = Reader.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Reader.nextInt();
        }

        dp[1] = A[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = A[i];
            for (int j = 1; j < i; j++) {
                if (A[j] < A[i] && (dp[i] < dp[j] + A[i])) {
                    dp[i] = dp[j] + A[i];
                }
            }
        }

        int answer = dp[1];
        for (int i = 2; i <= N; i++) {
            if (answer < dp[i]) {
                answer = dp[i];
            }
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
