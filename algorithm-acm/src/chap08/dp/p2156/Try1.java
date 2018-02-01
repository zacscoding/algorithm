package chap08.dp.p2156;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/2156
 *
 * @author zaccoding github : https://github.com/zacscoding
 * @Date : 2018-01-31
 */
public class Try1 {

    // i번쨰 포도주를 j==0 안마실 때 최대, j==1 마실 때 최대
    public static int[][] dp;
    public static int[] amount;

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int n = Reader.nextInt();
        amount = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            amount[i] = Reader.nextInt();
        }

        if(n <= 2) {
            System.out.println(n == 1 ? amount[1] : amount[1] + amount[2]);
            return;
        }


        dp = new int[n + 1][2];
        dp[1][1] = amount[1];
        dp[2][1] = amount[1] + amount[2];
        for (int i = 3; i <= n; i++) {
            int max = Math.max(dp[i-3][0], dp[i-3][1]);
            max = Math.max(max, Math.max(amount[i-2], amount[i-1]));
            dp[i][0] = Math.max(max, dp[i-3][0] + amount[i-2] + amount[i-1]);
            dp[i][1] = max + amount[i];
        }

        System.out.println(Math.max(dp[n][0], dp[n][1]));

        Reader.close();
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
