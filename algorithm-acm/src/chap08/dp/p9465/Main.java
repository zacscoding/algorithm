package chap08.dp.p9465;

import java.io.*;
import java.util.*;

/**
 * https://www.acmicpc.net/problem/9465
 * dp[i][j] ==  i번째 열의
 *  j==0 스티커 안띌때 최대
 *  j==1 위쪽 스티커 띌 때 최대
 *  j==2 아래쪽 스티커 뛸 때 최대
 * @author zacconding
 * @Date 2018-01-28
 * @GitHub : https://github.com/zacscoding
 */
public class Main {

    public static int n;
    public static int[][] score = new int[2][100000];

    public static void main(String[] args) throws IOException {
        Reader.init(System.in);
        int T = Reader.nextInt();
        while (T-- > 0) {
            n = Reader.nextInt();
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < n; j++) {
                    score[i][j] = Reader.nextInt();
                }
            }
            int[][] dp = new int[n][3];
            dp[0][1] = score[0][0];
            dp[0][2] = score[1][0];
            for (int i = 1; i < n; i++) {
                // dp[i][0]
                dp[i][0] = Math.max(dp[i-1][0], Math.max(dp[i-1][1], dp[i-1][2]));
                // dp[i][1]
                dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][2]) + score[0][i];
                // dp[i][2]
                dp[i][2] = Math.max(dp[i - 1][0], dp[i - 1][1]) + score[1][i];
            }
            int answer = Math.max(dp[n-1][0], Math.max(dp[n-1][1], dp[n-1][2]));
            System.out.println(answer);
        }

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
