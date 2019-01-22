package chap08.dp.p2293;

import java.io.*;
import java.util.*;

/**
 * fail
 * https://www.acmicpc.net/problem/2293
 */
public class Try1 {

    static int n;
    static int k;
    static int[] a;
    // k까지 합의 경우의 수
    static int[] dp;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);

        n = Reader.nextInt();
        k = Reader.nextInt();
        a = new int[n];
        dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            a[i] = Reader.nextInt();
        }

        for (int i = 0; i <= k; i++) {
            dp[i] = -1;
        }

        System.out.println(solve(k));
        System.out.println("kk");
    }

    public static int solve(int x) {
        if (dp[x] != -1) {
            return dp[x];
        }

        int cases = 0;

        for (int i = 0; i < a.length; i++) {
            if (x == a[i]) {
                cases++;
            }

            if (x - a[i] > 0) {
                cases += solve(x - a[i]);
            }
        }

        System.out.println("## Check x :: " + x + " :: " + cases);

        return dp[x] = cases;
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
