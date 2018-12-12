package chap08.dp.p9461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @author zacconding
 * @Date 2018-11-28
 * @GitHub : https://github.com/zacscoding
 */
public class Try1 {

    static final int mod = 1000000000;
    static int N;
    static int K;
    static int[][] dp = new int[21][3];

    public static void main(String[] args) {
        N = 20;
        K = 2;

        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 3;

        System.out.println(get(N, K));
        System.out.println("k");
    }

    public static int get(int a, int b) {
        if (dp[a][b] != 0) {
            return dp[a][b];
        }

        if(b == 1) {
            return dp[a][b] = 1;
        }

        int result = 0;
        for (int i = 1; i <= a; i++) {
            for (int j = 1; j <= i && j < b; j++) {
                result += (get(i, j) * get(a - i, b - j)) % mod;
            }
            result += (get(a - 1, b)) % mod;
        }
        return dp[a][b] = result;
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
