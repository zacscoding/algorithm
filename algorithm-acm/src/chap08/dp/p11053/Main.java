package chap08.dp.p11053;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/11053
 *
 * @author zacconding
 * @Date 2018-02-07
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    public static int[] A;
    // A[i]를 마지막으로 포함하는 가장 긴 수열의 수
    public static int[] dp = new int[1001];
    public static int N;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        N = Reader.nextInt();
        A = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = Reader.nextInt();
        }
        dp[1] = 1;
        int max = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = 1;
            for (int j = 1; j < i; j++) {
                if (A[j] < A[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    public static int solve(int idx, int max) {
        if (idx == 1) {
            return A[idx] < max ? 1 : 0;
        }
        return Math.max(solve(idx - 1, A[idx]) + 1, solve(idx - 1, max));
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
